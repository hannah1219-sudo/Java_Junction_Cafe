package org.javajunctioncafe;
import java.util.Scanner;
	public class Java_Junction_Cafe {
		
		static Scanner scan = new Scanner(System.in); 
		static int transaction, numDrink, drinkQuant, numPastry, pastryQuant,editOrder, addRemoveItems, pwdSubtotal; 
		static double vat = .20, disc =.20, dsPrice1, dsPrice, pPrice1, pPrice, subtotal; 
		static String transac, drinkQuantity, drinkCode, pastryQuantity, pastryCode, edit, editItems;
		static double[] prices = {99.00, 129.00, 149.00, 99.0, 129.0, 149.0,99.0, 129.0, 149.0, 119.0, 119.00, 59.00}; 
		static String[] orderNames = {"Latte Love (Tiny)", "Latte Love (Cozy)", "Latte Love (Mega)","Berry Bliss (Tiny)", "Berry Bliss (Cozy)", "Berry Bliss (Mega)",
		        "Java Jolt (Tiny)", "Java Jolt (Medium)", "Java Jolt (Mega)","Croissant Crush", "Lemon Curd Tart", "Hazelnut Haven Cookie" }; 
		static int[] quantities = new int[orderNames.length];
		static String[] drinkCodes = {"L1", "L2", "L3", "B1", "B2", "B3", "J1", "J2", "J3"}; static String [] pastryCodes = {"P1","P2", "P3"};
		static int[] drinkCounts = new int[9]; static int[] pastryCounts = new int [3]; 
		
	public static void displayMenu (Scanner scan) { 
			   System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------");
	    	   System.out.println("\t\t\t\t\t\t\t===WELCOME TO JAVA JUNCTION CAFE===");
	           System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
	           System.out.println("\t\t\t\t\t\t\t\tHERE IS THE MENU.");
	           System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
	           System.out.printf("\n%-30S%-18S%15S%27S%11S\n\n", "Drinks", "Tiny(8oz)", "Cozy(16oz)", "Mega(24oz)   ||", "Pastries");
	           System.out.printf("%-30s%-19s%14s%25s%25s\n", "[]Latte Love", "[L1]P99.00", "[L2]P129.00", "[L3]P149.00   ", "||   [P1]Croissant Crush(P119.00)");
	           System.out.printf("%-30s%-19s%14s%25s%25s\n", "[]Berry Bliss", "[B1]P99.00", "[B2]P129.00", "[B3]P149.00   ", "||   [P2]Lemon Curd Tart(P119.00)");
	           System.out.printf("%-30s%-19s%14s%25s%25s\n", "[]Java Jolt", "[J1]P99.00", "[J2]P129.00", "[J3]P149.00   ", "||   [P3]Hazelnut Haven Cookie(P59.00)");
	           System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
	           
	}public static int getTransaction(Scanner scan) { 
	    String transac;
	    int transaction = -1;
	    while (transaction < 0 || transaction > 4) {
	        System.out.print("\nCHOOSE YOUR TRANSACTION CODE." + "\n\n[1]Add Drink" + "\n[2]Add Pastry" + "\n[3]View Total Items/Edit Cart" + "\n[4]Finish Order" + "\n[0]EXIT" + "\n\nPlease Enter transaction code: ");
	        transac = scan.nextLine().trim();
	        if (!transac.equals("")) {
	            try {
	                transaction = Integer.parseInt(transac);
	                if (transaction < 0 || transaction > 4) {
	                    System.out.println("\nInvalid Input. Please Try Again.");
	                }
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid Input. Please Try Again.");
	            } } } return transaction;
	}public static int getDrinkQuantity() { 
	    int numDrink = 0;
	    do {
	        System.out.print("Quantity: ");
	        String drinkQuantity = scan.nextLine().trim();
	        try {
	            numDrink = Integer.parseInt(drinkQuantity);
	            if (numDrink <= 0) {
	                System.out.println("Invalid Quantity. Please enter a number greater than 0.");
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("Invalid Input. Please Try Again.");
	        } }while (numDrink <= 0);
	    return numDrink;
          
	}public static String[] getDrinkCode() { 
	    while (true) {
	        try {
	            System.out.print("Drink Code: ");
	            drinkCode = scan.nextLine().trim();
	            int index = -1;
	            for (int i = 0; i < drinkCodes.length; i++) { 
	                if (drinkCode.equals(drinkCodes[i])) { 
	                    index = i;
	                    break;
	                } }
	            if (index != -1) {
	            	String confirm="";
	            	System.out.print("Add item(s) to your cart? (y/n): ");
	            	confirm=scan.nextLine();
	            	if (confirm.equalsIgnoreCase("y")) {
		            	System.out.println("\n======================================");
	                    System.out.println(orderNames[index] + " was added to your cart.");
	                    System.out.println("======================================");
	                    quantities[index] += numDrink; 
		                drinkCounts[index] += numDrink; 
		                dsPrice1 = numDrink * prices[index]; 
		                dsPrice += dsPrice1; 
		                drinkQuant += numDrink; 
	            	}else if (confirm.equalsIgnoreCase("n")) {
	            		System.out.println("Item(s) was not added to your cart.");
           			main(null);
           			}else
	            		System.out.println("Invalid Input. Please Try Again.");
	            		main(null);
	            		} else {
	                throw new IllegalArgumentException("Invalid Drink Code. Please try again."); 
	            }
	            return drinkCodes;
	        } catch (IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        } }
	
	}public static int getPastryQuantity() { 
	    int numPastry = 0;
	    do {
	        System.out.print("Quantity: ");
	        String pastryQuantity = scan.nextLine().trim();
	        try {
	            numPastry = Integer.parseInt(pastryQuantity);
	            if (numPastry <= 0) {
	                System.out.println("Invalid Quantity. Please enter a number greater than 0.");
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("Invalid Input. Please Try Again.");
	        }
	        }while (numPastry <= 0);
	         return numPastry;
 
	}public static String[] getPastryCode() {
	    while (true) {
	        try {
	            System.out.print("Pastry Code: ");
	            pastryCode = scan.nextLine().trim();
	            int index = -1;
	            for (int i = 0; i < pastryCodes.length; i++) { 
	                if (pastryCode.equals(pastryCodes[i])) { 
	                    index = i; 
	                    break;
	                }
	            }
	            if (index != -1) {
	            	String confirm="";
	            	System.out.print("Add item(s) to your cart? (y/n): ");
	            	confirm=scan.nextLine();
	            	if (confirm.equalsIgnoreCase("y")) {
	            	System.out.println("\n======================================");
                   System.out.println(orderNames[index + 9] + " was added to your cart.");
                   System.out.println("======================================");
	                quantities[index + 9] += numPastry;
	                pastryCounts[index] += numPastry;
	                pPrice1 = numPastry * prices[index + 9];
	                pPrice += pPrice1;
	                pastryQuant += numPastry;
	            	}else if (confirm.equalsIgnoreCase("n")) {
	            		System.out.println("Item(s) was not added to your cart.");
           			main(null);
	            	}else
	            		System.out.println("Invalid Input. Please Try Again.");	
	            		main(null);
	            	}else {
	                throw new IllegalArgumentException("Invalid Pastry Code. Please Try Again.");
	            }
	            return pastryCodes;
	        } catch (IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }
	    }
	}
	public static void addItem(Scanner scan) { 
	    int transaction = 0; String choice="";
	    do {
	        System.out.print("\nCHOOSE YOUR TRANSACTION CODE" +
	                         "\n[1] Add Drink" +
	                         "\n[2] Add Pastry" +
	                         "\n[0] Exit" +
	                         "\nCHOICE: ");
	        choice=scan.nextLine();
	        try {
	        	transaction=Integer.parseInt(choice);
	        	if (transaction == 1) {
		        	numDrink=getDrinkQuantity();
		            getDrinkCode();
		        } else if (transaction == 2) {
		        	numPastry=getPastryQuantity();
		            getPastryCode();
		        } else if (transaction == 0) {
		            main(null);
		            System.exit(0);
		            break;  
		        } else {
		            System.out.println("Invalid Input. Please try again.");
		        }
	        }catch (Exception e) {
	        	System.out.println("Invalid Input. Please Try Again."); 
	        }
	    } while (transaction < 0 || transaction > 2);
	    	displayCart();
	} 
	public static void removeItem(Scanner scan) {
	    transaction = -1;
	    while (transaction < 0 || transaction > 2) {
	        System.out.print("\nCHOOSE YOUR TRANSACTION CODE" + "\n[1]Remove Drink" + "\n[2]Remove Pastry" + "\n[0]Exit" + "\n\nCHOICE: ");
	        try {
	            transaction = scan.nextInt();
	            scan.nextLine();
	        } catch (Exception e) {
	            System.out.println("Invalid Input. Please Try Again.");
	            scan.nextLine();
	            continue;
	        } }
	    if (transaction == 0) {
	        main(null);
	        }
	    if (transaction == 1) {
	        while (true) {
	            System.out.print("Drink Code: ");
	            String drinkCode = scan.nextLine().trim();
	            int index = -1;
	            for (int i = 0; i < drinkCodes.length; i++) {
	                if (drinkCode.equals(drinkCodes[i])) {
	                    index = i;
	                    break; 
	                } }
	            if (index != -1) {
	                if (quantities[index] <= 0 || drinkCounts[index] <= 0) {
	                    System.out.println("This drink is not in your cart or has already been removed.");
	                    break;
	                } else {
	                    while (true) {
	                        System.out.print("Quantity: ");
	                        try {
	                            numDrink = scan.nextInt();
	                            scan.nextLine();
	                            if (numDrink <= 0) {
	                                System.out.println("Invalid Input. Please enter a quantity greater than 0.");
	                                continue;
	                            } if (numDrink > quantities[index]) {
	                                System.out.println("You cannot remove more than the available quantity in your cart.");
	                                continue;
	                            } break;
	                        } catch (Exception e) {
	                            System.out.println("Invalid Input. Please enter a valid number.");
	                            scan.nextLine();
	                        }
	                    }String confirm="";
		            	System.out.print("Remove item(s) to your cart? (y/n): ");
		            	confirm=scan.nextLine();
		            	if (confirm.equalsIgnoreCase("y")) {
		                    System.out.println("\n=================================");
		                    System.out.println(orderNames[index] + " was removed from your cart.");
		                    System.out.println("=================================");
		                    quantities[index] -= numDrink; drinkQuant -= numDrink; drinkCounts[index] -= numDrink;
		                    dsPrice1 = numDrink * prices[index]; dsPrice -= dsPrice1;
		            	}else if (confirm.equalsIgnoreCase("n")) {
		            		System.out.println("Item(s) was not added to your cart.");
	            			main(null);
	            			}else
		            		System.out.println("Invalid Input. Please Try Again.");
	            			main(null);
	                }
	            	}else {
	                System.out.println("Invalid Drink Code. Please try again.");
	            }
	            } } else if (transaction == 2) {
	        while (true) {
	            System.out.print("Pastry Code: ");
	            String pastryCode = scan.nextLine().trim();
	            int index = -1;
	            for (int i = 0; i < pastryCodes.length; i++) {
	                if (pastryCode.equals(pastryCodes[i])) {
	                    index = i;
	                    break;
	                } }
	            if (index != -1) {
	                if (pastryCounts[index] <= 0) {
	                    System.out.println("This pastry is not in your cart or has already been removed.");
	                    break;
	                } else {
	                    while (true) {
	                        System.out.print("Quantity: ");
	                        try {
	                            numPastry = scan.nextInt();
	                            scan.nextLine();  
	                            if (numPastry <= 0) {
	                                System.out.println("Invalid Input. Please enter a quantity greater than 0.");
	                                continue;
	                            } if (numPastry > pastryCounts[index]) {
	                                System.out.println("You cannot remove more than the available quantity in your cart.");
	                                continue;
	                            } break;
	                        } catch (Exception e) {
	                            System.out.println("Invalid Input. Please enter a valid number.");
	                            scan.nextLine();
	                        } }
	                    String confirm="";
		            	System.out.print("Remove item(s) to your cart? (y/n): ");
		            	confirm=scan.nextLine();
		            	if (confirm.equalsIgnoreCase("y")) {
		                    System.out.println("\n=================================");
		                    System.out.println(orderNames[index+9] + " was removed from your cart.");
		                    System.out.println("=================================");
		                    quantities[index+9]-=numPastry; pastryCounts[index] -= numPastry; pastryQuant -= numPastry; 
		                    pPrice1 = numPastry * prices[index+9]; pPrice -= pPrice1;
		            	}else if (confirm.equalsIgnoreCase("n")) {
		            		System.out.println("Item(s) was not added to your cart.");
	            			main(null);
		            	}else
		            			System.out.println("Invalid Input. Please Try Again.");
	            				main(null);
	                } } else
	                System.out.println("Invalid Pastry Code. Please try again.");
	             }
	        }
	} public static void clearCart() {
	    for (int i = 0; i < drinkCodes.length; i++) {
	        quantities[i] = 0; 
	        drinkQuant = 0;     
	        drinkCounts[i] = 0; 
	        dsPrice = 0;        
	    } for (int i = 0; i < pastryCodes.length; i++) {
	        quantities[i+9] = 0;  
	        pastryQuant = 0;     
	        pastryCounts[i] = 0; 
	        pPrice = 0;         
	    } subtotal = 0;  
	    System.out.println("All items have been cleared from the cart.");
	}
	public static void displayCart() {
	    subtotal = 0.0;
	    int itemCount = 0; 
	    for (int order = 0; order < orderNames.length; order++) {
	        if (quantities[order] > 0) {
	            double itemSubtotal = prices[order] * quantities[order];
	            subtotal += itemSubtotal; 
	            if (itemCount == 0) {
	                System.out.println("\nYour cart contains:");
	            }
	            if (order < 9) { 
	                System.out.println(quantities[order] + " x " + orderNames[order] + " (Drink) - " + itemSubtotal);
	            } else {
	                System.out.println(quantities[order] + " x " + orderNames[order] + " (Pastry) - " + itemSubtotal);
	            } itemCount++;
	        }
	    } if (subtotal == 0) { 
	        System.out.println("Your cart is empty.");
	    } else {
	        System.out.println("Subtotal: " + subtotal);
	    }
	}
	public static int editCart() {
		do {
			System.out.print("\nCHOOSE YOUR TRANSACTION CODE" + "\n[1]Add Item(s)" + "\n[2]Remove Item(s)" + "\n[3]Clear Cart" + "\n[0]Exit"+ "\n\nCHOICE: ");
			editItems=scan.nextLine();
			try{
				addRemoveItems=Integer.parseInt(editItems);
			}catch (NumberFormatException e) {
				System.out.println("Invalid Input. Please Try Again.");
			}
		    if (addRemoveItems<0||addRemoveItems>3 )
		    		System.out.println("Invalid Input. Please Try Again.");
		    else if (addRemoveItems==1)
		    		addItem(scan);
		    else if (addRemoveItems==2)
		    		removeItem(scan);
		    else if (addRemoveItems==3)
		    	clearCart();
		    else if (addRemoveItems==0)
		    	main(null);
		}while (addRemoveItems!=0);
			return addRemoveItems;		
	}
	public static int getDiscount(Scanner scan) {
	    int discount = -1; 
	    while (discount < 0 || discount > 1) {
	        System.out.print("\n[1]YES and [0]NO.\nAre you a PWD OR Senior Citizen?: ");
	        String PWD = scan.nextLine();
	        try {
	            discount = Integer.parseInt(PWD);
	        } catch (NumberFormatException e) {
	            System.out.println("\nPlease enter a valid number.");
	        }
	    } return discount;
	}
	public static double getTotalAmount(double subtotal, int discount, double vat, double disc) {
	    double totalAmount = 0.0;
	    double pwdSubtotal = 0.0;
	    if (discount == 1) {
	        pwdSubtotal = (subtotal + (subtotal * vat));
	        totalAmount = (pwdSubtotal - (pwdSubtotal * disc));
	        System.out.printf("\nTotal Amount (with PWD/Senior Discount): %.2f\n", totalAmount);
	    }else if (discount == 0) {
	        totalAmount = (subtotal + (subtotal * vat));
	        System.out.printf("\nTotal Amount (no discount): %.2f\n", totalAmount);
	    } return totalAmount;
	}
	public static double getCash(Scanner scan, double totalAmount) { 
	    double cash = 0.0;
	    while (cash < totalAmount || cash <= 0) {
	        System.out.print("\nEnter Cash to Pay: ");
	        String money = scan.nextLine();
	        try {
	            cash = Double.parseDouble(money);
	            if (cash < totalAmount) {
	                System.out.println("\nInsufficient Amount. Please Try Again.");
	            } else if (cash <= 0) {
	                System.out.println("\nInvalid Amount. Please Try Again.");
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("\nInvalid Input. Please Try Again.");
	        }
	    } return cash;
	}
	public static double processPayment(Scanner scan) { 
	    displayCart();
	    if (subtotal <= 0) { 
	        main(null);
	        }else {
		    int discount = getDiscount(scan);
		    double totalAmount = getTotalAmount(subtotal, discount, vat, disc);
		    double cash = getCash(scan, totalAmount);  
		    if (cash >= totalAmount) {
		        printReceipt(drinkQuant, pastryQuant, subtotal, totalAmount, cash, discount);
		        return cash - totalAmount; 
		    } else {
		        System.out.println("Insufficient cash. Please enter a valid amount.");
		    }
	    }
	    return processPayment(scan);
	}
	public static void printReceipt(int drinkQuant, int pastryQuant, double subtotal, double totalAmount, double cash, int discount) {
	    System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------");
	    System.out.println("JAVA JUNCTION CAFE" + "\nOperated by: CHE AND TEAHOUSE CORPORATION" + "\nDISCO FOOD HOUSE" + "\nCITY OF MALOLOS BULACAN" + "\nPHILIPPINES");
	    System.out.println("\n=============RECEIPT=============");
	    System.out.println("\n---------------------------------");
	    System.out.println("\nTOTAL ORDER(S): " + (drinkQuant + pastryQuant));
	    double receiptSubtotal = 0.0;
	    for (int order = 0; order < orderNames.length; order++) { 
	        if (quantities[order] > 0) {
	            double itemSubtotal = prices[order] * quantities[order];
	            receiptSubtotal += itemSubtotal; 
	            if (order < 9) {
	                System.out.println(quantities[order] + " x " + orderNames[order] + " (Drink) - Total: " + itemSubtotal);
	            } else {
	                System.out.println(quantities[order] + " x " + orderNames[order] + " (Pastry) - Total: " + itemSubtotal);
	            }
	        }
	    }
	    System.out.println("\n---------------------------------");
	    System.out.printf("VAT: %.2f\n", (receiptSubtotal * vat));
	    if (discount == 1) {
	        System.out.printf("DISCOUNT: %.2f\n", (receiptSubtotal + (receiptSubtotal * vat)) * disc);
	    } else {
	        System.out.println("DISCOUNT: NONE");
	    }
	    System.out.println("\n---------------------------------");
	    System.out.printf("TOTAL AMOUNT: %.2f\n", totalAmount);
	    System.out.printf("\nCASH: %.2f\n", cash);
	    System.out.printf("CHANGE: %.2f\n", (cash - totalAmount));    
	    System.out.println("\n=================================");
	    System.out.println("\nTHIS SERVES AS A SALES INVOICE." + "\nWe look forward to seeing you again!" + "\nContact us at 0912 345 678" + "\nor email at jj@customerservice");
	    System.exit(0);
	}	
	public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
	    while (true) {
	        displayMenu(scan);
	        int transaction = getTransaction(scan);
	        if (transaction == 1) {
	            numDrink = getDrinkQuantity();
	            getDrinkCode();
	        } else if (transaction == 2) {
	            numPastry = getPastryQuantity();
	            getPastryCode();
	        } else if (transaction == 3) {
	            displayCart();
	            if (subtotal <= 0) continue;
	            int addRemoveItems = editCart();
	            if (addRemoveItems == 1) {
	                addItem(scan);
	            } else if (addRemoveItems == 2) {
	                removeItem(scan);
	            } else if (addRemoveItems == 0) {
	               break;
	            }
	        } else if (transaction == 4) {
	        	processPayment(scan);
	            break;
	        } else if (transaction == 0) {
	            System.out.println("Thank you for visiting Java Junction!");
	            System.exit(0);
	            break;
	        }
	    }
	}
}