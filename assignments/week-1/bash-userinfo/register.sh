#!/bin/bash

clear;

#extract logic into functions for readability and reuseability
get_names() {
    echo 'Please enter your First and Last Name, separated by a space:';
    read firstname lastname;
}

get_email() {
    echo 'Please register an email:';
    read email;
    # validate that email does not exist in database
    # validate that email is formatted correctly
}

get_username() {
    echo 'Enter a new Username:';
    read username;
    # validate that usernames do not already exist in database
}

get_password() {    
    echo 'Enter a new Password: (input will be invisible)';
    read -s password;
    echo 'Please re-enter password.';
    read -s password2;

    if [ $password == $password2 ] 
    then
        echo 'Passwords matched successfully!';
    else
        echo 'Error: Passwords do not match. Please try again.';
        get_password;
    fi;

    # bonus: validate passwords to have a certain level of complexity eg: "one character and one number and one symbol... ect"
    # bonus: encrypt passwords
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
echo "Password: *****";
echo "email: ${email}";
echo "--------------------------------";

echo "Is this information correct? [y/N] (prompt will restart if not)";
read -r response;
if [[ "$response" =~ ^([yY][eE][sS]|[yY])$ ]]
then
    output="${firstname},${lastname},${email},${username},${password}";
    echo "Saving data..."
    # save this information to a csv file
    echo $output >> output.csv;

    echo "Done! Thank you for registering with us. Your business is very important to us!"
else
    # restart the program
    read -p "Press Enter to restart.";
    exec ./${0};
fi
