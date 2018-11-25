use std::process::exit; // Error handling
use std::io::Write; // Need the write trait's flush method
use std::io; // Need access to stdin

fn main() {

    println!("This program prints the power set of the set of natural numbers [0, n].");
    io::stdout().flush().unwrap();

    // Make a string to get the input and n to hold the input's value
    let mut number: i32;

    loop {

        let mut input = String::new();

        // Get the input and handle potential failure
        match io::stdin().read_line(&mut input) {
            Ok(_v) => {},
            Err(_e) => {
                println!("Couldn't read your input");
                exit(1);
            },
        }

        // Turn the string into a number... remember to trim whitespace
        number = match input.trim()
            .parse() {
                Ok(n) => n, // You have to put this first: match infers its return type from the first match arm
                Err(_e) => {
                    println!("{}", _e);
                    println!("Your 'number' n contains invalid digits.");
                    continue;
                },
        };

        // Check that the input is fine
        if number < 0 {
            println!("N must be >= 0.");
            continue;
        } else if number > 10 {
            println!("N must be <= 10.");
            continue;
        } else { break; }
    }

    print!("The powerset of {{");

    for i in 0..=number {
        if i < number {
            print!("{}, ", i);
        } else if i==number {
            print!("{}", i);
        }
    }

    println!("}} is: \n");

    for i in 0..2<<number {
        let mut has_printed = false;

        for j in 0..=number {
            let masked = (i>>j)&1;
            if masked == 1 {
                if !has_printed {
                    has_printed = true
                } else {
                    print!(", ")
                }
                print!("{}", j)
            }

            if j == number { print!("\n"); }
        }
    }


}
