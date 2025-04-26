//package EcojoziBackEnd;
//import java.util.*;
//
//public class Main{
//
//	/** Commenting this out because im working on the GUI & it needs a main - adan
//	 
//	 
//	public static void main(String[] args) {
//		
//		// Creating all necessary object instances for the Game:
//		Scanner input = new Scanner(System.in); // Creating a Scanner object, called input
//		Game game = new Game();// This is used to create the Game 
//		AllianceManager alliances = new AllianceManager(); // Creating alliances allianceManager: This is going to keep track of all the alliances formed
//		ArrayList<Player> players = new ArrayList<Player>(); // Creating ArrayList of player objects to keep track of all the player records
//		
//		
//		
//		setUpPlayers(input, players); // Setting up the players first, before Moving onto the Menu (According to Set Up Game Use Case)
//		System.out.println("Setting up the game..."); // Formatting purposes
//		System.out.println("Game setup complete!"); // Formatting purposes
//		System.out.println("Welcome to Ecojozi!"); // Formatting purposes
//		System.out.println();
//		
//		
//		mainMenuOperation(input, game, players, alliances); // displaying game menu & asking for user input
//		
//		input.close(); // Closing the Scanner
//
//	}
//	
//	*/
//
//	
//	
//	
//	/**
//	 * This function prompts the user to pick an option from the game menu
//	 * All invalid inputs are handled by illegal exceptions
//	 * 
//	 * @param input: Scanner
//	 * @param game: Game object instance
//	 */
//	public static void mainMenuOperation(Scanner input, Game game, ArrayList<Player> players, AllianceManager alliances) {
//		
//		game.displayMenu(); // displaying the menu
//		
//		System.out.print("Choose an option: "); // asking the user for input
//		int userChoice = input.nextInt(); // taking user input using scanner & storing it in userChoice variable
//		System.out.println();
//		
//		switch(userChoice) { // switching on the userChoice variable input
//		case 1:
//			
//			runGame(game, players, alliances, input); // This runs the game
//			break;
//			
//		case 2:
//			
//			game.displayTutorial(); // --- 
//			break;
//			
//		case 3:
//			
//			game.configureAccessibility();
//			break;
//			
//		case 4:
//			
//			game.endGame();
//			break;
//			
//			default:
//				
//				System.out.print("Invalid Option. Please Try Again.");
//				System.out.println();
//				mainMenuOperation(input, game, players, alliances);
//				
//		}
//		
//	}
//	
//	
//	
//	/**
//	 * When the 1st (Start Game Option) is picked from the main Menu, this method is called
//	 * 
//	 * @param game: uses the game instance
//	 */
//	
//	
//	
//	
//	
//	
//	/**
//	 * This method takes care of all the operation/functionality of the Player Menu (Mini-Menu) when a player lands on a square
//	 * 
//	 * @param player: current player instance
//	 */
//	public static void miniMenuOperation(Player player, Game game, Scanner input, AllianceManager alliances, ArrayList<Player> players) {
//
//		// Displaying the miniMenu:
//		if (checkIfInAlliance(player, alliances)) { // Checking if currentPlayer is in an alliance
//			miniAllianceMenu(); // display miniAllianceMenu
//			
//			System.out.print("Choose an option: "); // asking the user for input
//			int userChoice = input.nextInt(); // taking user input using scanner & storing it in userChoice variable
//			
//			switch(userChoice) { // switching on the userChoice variable input
//			case 1:
//				
//				/**
//				 * Need:
//				 * 
//				 * allocateResourcesFuncationality
//				 * -> Checks if player has enough money to allocate resources
//				 * 
//				 * -> cross-checks if player is sure they want to allocate this much amount
//				 * 
//				 * -> Checks if the amount is less than what is required (so dont over exceede)
//				 *  
//				 */
//				
//				player.allocatedSquareResources(userChoice);
//				
//				//check to see if a task has been claimed
//				//if a task has not been claimed then call the case 2 method 
//				break;
//				
//			case 2:
//				
//				//claimTask(player,input,game, alliances, players);
//				
//				break;
//				
//			case 3:
//				
//				
//				break;
//				
//			case 4:
//				nextTurn(players, game); // Skipping the current players turn
//				break;
//				
//			default:
//					
//					System.out.print("Invalid Option. Please Try Again.");
//					System.out.println();
//					miniMenuOperation(player, game, input, alliances, players);
//					
//			}
//			
//
//		} else {
//			miniMenu(); // formatting
//			
//			
//			
//		}
//
//	}
//	
//	/**
//	 * 
//	 * 
//	 * - Checks if player has enough money to allocate resources
//	 * 
//	 * - Cross-checks if player is sure they want to allocate this much amount (According to use case description)
//	 * 
//	 * - Checks if the amount is less than or equal to what is required (so don't over exceed)
//	 * 
//	 * - 
//	 * 
//	 * @param player
//	 */
//	public static void allocateResourcesFuncationality(Player player) {
//		
//	}
//	
//	
//	/**
//	 * This method checks if the player is in an alliance (with every other player)
//	 * 
//	 * @param player: current player instance
//	 * @return: returns true, if player is in an alliance, else false
//	 */
//	public static boolean checkIfInAlliance(Player player, AllianceManager alliances) {
//		List<Alliance>allianceArrayList = alliances.getAllAlliances(); // Getting the arrayList of all alliances
//		
//		for(int i=0; i<allianceArrayList.size(); i++) { // going through each element of the array list
//			
//			allianceArrayList.contains(player); // checking the array list
//			return true; // if the allianceArrayList contains the current player (i.e the current player is in an alliance with any other player, return true)
//			
//		}
//		
//		return false ;  // else return false
//	}
//	
//	
//
//	/**
//	 * This is the Mini-Menu that appears when a player lands on a Square
//	 */
//	public static void miniMenu() {
//		System.out.println("+----------------------------------+");
//		System.out.println("|           Player Menu            |");
//		System.out.println("+----------------------------------+");
//        System.out.println("|1. Form Alliance                  |"); // -- 
//        System.out.println("|2. Allocate Resources             |"); // current active task: 1. 2. (sharing with someone else, whenever u form an alliance, it automatically groups both players tasks)
//        System.out.println("|3. Claim Task                     |"); // ---- just display task
//        System.out.println("|4. End Turn                       |"); // ------ nextTurn();
//        System.out.println("+----------------------------------+");
//	}
//	
//	/**
//	 * This is the Mini-Menu that appears when a player (WHO IS IN AN ALLIANCE) lands on a Square
//	 */
//	public static void miniAllianceMenu() {
//		System.out.println("+----------------------------------+");
//		System.out.println("|           Player Menu            |");
//		System.out.println("+----------------------------------+");
//        System.out.println("|1. Allocate Resources             |"); // 
//        System.out.println("|2. Claim Task                     |"); // ---- just display task
//        System.out.println("|3. End Turn                       |"); // ------
//        System.out.println("+----------------------------------+");
//	}
//	
//	// Ryan -  Commenting this out because idk what the fuck this does
////	public static void verifyMiniAmount(Scanner input, Player player,Task task) {
////		System.out.print("Input amount to allocate: ");
////		int userInput = input.nextInt();
////		if(userInput>=task.getDeposit()) {
////			boolean flag2 = player.allocateResourcesPlayer(player, userInput,task);
////			if(flag2) {
////				player.updateTaskCounter();
////				
////			}
////		} else {
////			System.out.println("Insufficient amount to claim task. Please try again");
////			verifyMiniAmount(input,player,task);
////			
////		}
////	}
//	
//	
//		
//	
//		
//
//
//	
//}
