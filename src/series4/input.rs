use std::process::exit; // Error handling
use std::io::Write; // Need the write trait's flush method
use std::io; // Need access to stdin

fn main() {

    println!("This is an example of how to do input (without using useful macros from crates [→ ])");
    println!("If you enter 42, the program will exit.");

    // I have to flush explicitely to empty the stdout buffer,
    // or the system will only run the println! after the read_line()
    // below... (that's auto-bundling)
    io::stdout().flush().unwrap();
    // Note: flush is part of the write trait

    // Where to put the parsed input
    let mut number: i32;


    loop {

        // Make a string to get the input
        let mut input = String::new();
        // Note: the input buffer is in the loop so that it is overwritten on every iteration.
        // If you don't do that (or sth of equal effect) parse() might fail due to left-over
        // characters from a previous iteration. Eg: If you put the declaration for input before
        // the loop and you enter a non-number on one iteration and a number on the next, parse()
        // will reliably fail.

        // Get the input and handle potential failure
        match io::stdin().read_line(&mut input) {
            Ok(_v) => {},
            Err(_e) => {
                println!("Couldn't read your input");
                continue;
            },
        }

        // Turn the string into a number... remember to trim whitespace
        number = match input.trim()
            .parse::<i32>() {
                Ok(n) => n, // You have to put this first: match infers its return type from the first match arm
                Err(_e) => {
                    println!("Your 'number' contains invalid digits.");
                    continue;
                },
        };

        // Exit if number is 42
        if number == 42 { exit(0); }

        // Ping back the input
        println!("Your entered number is: {}", number);

    }

}
