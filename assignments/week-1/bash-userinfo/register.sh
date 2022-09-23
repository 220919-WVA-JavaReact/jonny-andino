#!/bin/bash

clear;

#extract logic into functions for readability and reuseability
get_names() {
    echo 'Please enter your First and Last Name, separated by a space:';
    read firstname lastname;
    if [[ "$firstname" =~ [a-zA-Z] ]] && [[ "$lastname" =~ [a-zA-Z] ]]
    then
        echo "Name format $firstname $lastname is valid."
        break
    else
        echo "Name format is invalid. Please try again."
        get_names
    fi
}

get_email() {
    echo 'Please register an email:';
    read email;
    # validate that email is formatted correctly
    if [[ "$email" =~ ^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$ ]]
    then
        echo "Email address $email is valid."
        break
    else
        echo "Email address $email is invalid. Please try again."
        get_email
    fi
    # todo: validate that email does not exist in database
    found_email=`sh lookup.sh MOCK_DATA.csv 'Email address' ${email}`
    if ! [[ -z "$found_email" ]]
    then
        echo 'email already exists. Please enter another'
        get_email
    fi
}

get_username() {
    echo 'Enter a new Username:';
    read username;
    # todo: validate that usernames do not already exist in database
    found_user=`sh lookup.sh MOCK_DATA.csv Username ${username}`
    if ! [[ -z "$found_user" ]]
    then
        echo 'Username already exists. Please enter another'
        get_username
    fi
}

get_password() {    
    # ask for password twice, we use the -s flag so it doesn't show on the screen
    echo 'Enter a new Password: (input will be invisible)';
    read -s password;
    echo 'Please re-enter password.';
    read -s password2;

    if [ $password == $password2 ] 
    then
        echo 'Passwords matched successfully!';
        # bonus: base64 encrypt passwords
        password_encoded=`echo $password | base64`
    else
        echo 'Error: Passwords do not match. Please try again.';
        get_password;
    fi;

    # bonus: validate passwords to have a certain level of complexity eg: "one character and one number and one symbol... ect"
}

# take in a firstname, lastname, username, email and password
get_names;
get_username;
get_email;
get_password;

#validate that the info is correct
echo "--------------------------------";
echo "Name: ${firstname} ${lastname}";
echo "Username: ${username}";
echo "Password: (hidden)";
echo "email: ${email}";
echo "--------------------------------";

echo "Is this information correct? [y/N] (prompt will restart if not)";
read -r response;
if [[ "$response" =~ ^([yY][eE][sS]|[yY])$ ]]
then
    output="${firstname},${lastname},${email},${username},${password_encoded}";
    echo "Saving data..."
    # save this information to a csv file
    echo $output >> output.csv;

    echo "Done! Thank you for registering. Your business is very important to us!"
else
    # restart the program
    read -p "Press Enter to restart.";
    exec ./${0};
fi
