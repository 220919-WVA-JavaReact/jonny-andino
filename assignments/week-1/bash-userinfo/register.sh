#!/bin/bash

clear;

db="MOCK_DATA.csv"

#extract logic into functions for readability and reuseability
get_names() {
    echo 'Please enter your First and Last Name, separated by a space:';
    read firstname lastname;
    if [[ "$firstname" =~ [a-zA-Z] ]] && [[ "$lastname" =~ [a-zA-Z] ]]
    # i could do better validation here, right now only accounds for a-z. :/
    then
        echo "Welcome, ${firstname}!"
    else
        echo "Error: Name format is invalid. Please try again."
        get_names
    fi
}

get_email() {
    echo 'Please register an email:';
    read email;
    # validate that email is formatted correctly
    
    if ! [[ "$email" =~ ^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$ ]]
    # if email does NOT look like an email, try again
    then
        echo "Error: Email address $email is invalid. Please try again."
        get_email
    fi
    
    # validate that email does not exist in database
    
    found_email=`sh lookup.sh ${db} 'Email address' ${email}`
    # lookup.sh will return nothing or the corresponding entry if it finds a match
    # so, we're asking 'if the value saved in found_email is NOT nothing, then retry the email'
    if ! [[ -z "$found_email" ]]
    then
        echo 'Error: Email address already exists. Please enter another'
        get_email
    fi
}

get_username() {
    echo 'Enter a new Username:';
    read username;
    # todo: validate that usernames do not already exist in database
    found_user=`sh lookup.sh ${db} Username ${username}`
    if ! [[ -z "$found_user" ]]
    then
        echo 'Error: Username already exists. Please enter another'
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

# here i am calling the functions i defined earlier to gather and validate the input data

get_names;
get_email;
get_username;
get_password;

# now, validate with the user that their info is correct
echo "--------------------------------";
echo "Name: ${firstname} ${lastname}";
echo "Username: ${username}";
echo "Password: (hidden)";
echo "email: ${email}";
echo "--------------------------------";

echo "Is this information correct? [y/N] (prompt will restart if not)";
read -r response;
if [[ "$response" =~ ^([yY][eE][sS]|[yY])$ ]]
# this regex checks for any capitalization of 'yes' or 'y'
then
    # create our output string with commas between the values
    output="${firstname},${lastname},${email},${username},${password_encoded}";
    echo "Saving data..."
    
    # save this information to the csv file
    echo $output >> $db;

    echo "Done! Thank you for registering. Your business is very important to us!"
else
    # restart the program
    read -p "Press Enter to restart.";
    exec ./${0};
fi