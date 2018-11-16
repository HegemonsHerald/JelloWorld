
fn main() {

    let n: u64 = 93;

    // Memory can be an array (fixed size), cause at fib(93) you run into an overflow
    let mut fib_memo = [0u64; 93];
    fib_memo[0] = 1;
    fib_memo[1] = 1;

    for i in 2..n {
        let a = i as usize;

        let fib_new: u64 = fib_memo[a-1] + fib_memo[a-2];
        fib_memo[a] = fib_new;

        println!("fib_memo[{}]: {}", a, fib_memo[a]);
    }

}
