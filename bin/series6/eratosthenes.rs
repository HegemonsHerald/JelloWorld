
/// Is a thing a prime?
fn is_prime(a:i32) -> bool {
    for i in 2..a {
        if a%i==0 { return false }
    }

    return true
}

fn main() {

    /* Init data structure */

    // The numbers
    let mut numbers: [i32;19] = [0;19];

    // Fill in the array
    numbers[0] = 2;

    for i in 1..numbers.len() {
        numbers[i] = numbers[i-1]+1;
    }
    // Note: if I were to use an iterator, I'd have to use map or sth like that.

    numbers.iter().for_each(|x| print!("{} ", x)); print!("\n");

    /* Compute Eratosthenes */

    for i in 0..numbers.len() {

        let n = numbers[i];

        // If it's been dealt with...
        if n == 0 { continue }

        // If it's prime...
        else if is_prime(n) {

            // Counter
            let mut m = 2; // start at 2 cause else you'd overwrite the prime

            // Loop til you found the last multiple in range of the numbers
            while (n as usize)*m < numbers.len() +2 {

                // Turn the multiples to 0
                numbers[(n as usize)*m -2] = 0;

                // Continue
                m += 1;

            }

            // Output the prime number
            println!("{}", n);

        // If there's nothing to do...
        } else { continue }

    }

    numbers.iter().for_each(|x| print!("{} ", x)); print!("\n");

    /*
    // Iterator implementation
    let primes: Vec<i32> = numbers.iter().filter(|&x| is_prime(*x)).map(|&x| x).collect();

    // Note: this isn't actually Eratosthenes, cause I don't skip any of the numbers. This is
    // literally just a linear checker. But it's sooooo pretty compared to the above =) !
    // I'm not sure the borrow checker even allows to edit the Iterator, while iterating over
    // it in case of arrays (and vectors?)

    // 1. you can't collect into an array, cause array can't support the intoIterator trait, which
    //    collec requires.
    //
    // 2. since I don't use into_iter(), which isn't implemented for the array either, I only
    //    get borrows to numbers' values passed to filter. filters' closure on top of that takes
    //    a borrow as argument. So I dereference the closure's borrow in its argument pattern `&x`
    //    and the iter() borrow in is_prime with `*x`.
    //
    // 3. filter returns an iterator containing only those elements of the previous iterator,
    //    that satisfy the predicate closure. As we established before, those elements passed
    //    along are all borrows. I use map to dereference these borrows, before collecting them
    //    into a new collection (the values are numbers, I want the numbers).
    //    Instead of using the pattern to deref you could also use `|x| *x` as the closure.


    // Output
    primes.iter().for_each(|x| println!("{}", x));
    */

}
