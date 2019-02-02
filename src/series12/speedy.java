/*
 * - add keyboard handlers for the buttons in init()
 * - override the handler functions to change gamestate appropriately...
 *    space	start a game round, so change game-state to running	RUNNING
 *    q		if waiting/idling exit the game				EXITING
 *    n		create new maze						GENERATING
 *    up,down	motion
 * - add a collision detection based on that getelementatxyz function from the acm...
 *
 * gameplay stops looping the moment that gameframe doesn't do anything, so gameframe needs to check the state for RUNNING
 * when the end condition is reached, gameframe needs to set the state to WAITING
 * the gameplay returns and gameloop calls gamewait, which will call the new generation method when the state changes to GENERATING
 * and returns when the state is STRATING
 *
 *
 * so the up, down and collision logic, as well as gthe game over logic has to be made with handlers and gameframe.
 * and the other handlers just need to change global state and wait for the game to react.
 *
 * I fucking hate this kind of even state model. Why can't we use one global update function and an event-stack to bubble interrupts? like good people you fucktards?
 *
 * EVENT DRIVEN PROGRAMMING IS NOT A RESOURCE EFFICIENT SOLUTION TO ANY THING.
 *
 */
