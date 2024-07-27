import java.util.ArrayList;
import java.util.Scanner;
/**
 * Contains the main driver for the Hotel Reservartion Systen
*/
public class HRS{ 
    public static void main(String[] args){
        ArrayList <Hotel> hotelList = new ArrayList <>();
        Scanner act = new Scanner(System.in);
        Scanner str = new Scanner(System.in);
        Scanner cha = new Scanner(System.in);
        Scanner doub = new Scanner(System.in);
        int action = -1;
        HRSGUI gui = new HRSGUI();
        //Controller controller =  new Controller(gui, HRS);

        System.out.println("Welcome to Aldrin's Hotel Reservation System!");
        
        while(action != 6){ //Main menu UI, keeps looping until 6 (Quit Program) is inputted
            System.out.println("MAIN MENU");
            System.out.println("Input the number of your desired course of action.");
            System.out.println("[1] Create Hotel [2] Delete Hotel");
            System.out.println("[3] View Hotel [4] Manage Hotel");
            System.out.println("[5] Make Booking [6] Quit Program");
            action = act.nextInt();
            switch (action) {
                case 1 -> { //Create Hotel UI
                    int numberOfRooms = 0;
                    int standardRooms = -1;
                    int deluxeRooms = -1;
                    int executiveRooms = -1;
                    while (standardRooms < 0 || standardRooms > 50){ //allows you to add between 1 to 50 rooms
                        System.out.println("Input number of Standard Rooms: ");
                        standardRooms = act.nextInt();
                    }
                    numberOfRooms += standardRooms;
                    while (deluxeRooms < 0 || numberOfRooms + deluxeRooms > 50){ //allows you to add between 1 to 50 rooms
                        System.out.println("Input number of Deluxe Rooms: ");
                        deluxeRooms = act.nextInt();
                    }
                    numberOfRooms += deluxeRooms;
                    while (executiveRooms < 0 || numberOfRooms + executiveRooms > 50){ //allows you to add between 1 to 50 rooms
                        System.out.println("Input number of Executive Rooms: ");
                        executiveRooms = act.nextInt();
                    }
                    numberOfRooms += executiveRooms;
                    System.out.println("Input name of new Hotel: ");
                    String newHotelName = str.nextLine();
                    int i, usedCheck = 0;
                    if (!hotelList.isEmpty()){ //checks if inputted hotel name is unique
                        for (i = 0; i < hotelList.size(); i++){
                            if (newHotelName.equals(hotelList.get(i).getHotelName()) == true)
                                usedCheck++;
                        }
                    }   
                    if (usedCheck == 0 && numberOfRooms > 0){ //adds the hotel into the system with its rooms
                        hotelList.add(new Hotel(newHotelName, numberOfRooms, standardRooms, deluxeRooms, executiveRooms));
                        System.out.println(newHotelName + " was added into the system with " + numberOfRooms + " rooms.");
                    }
                    else if (usedCheck == 0 && numberOfRooms == 0){ //adds the hotel into the system without any rooms
                        hotelList.add(new Hotel(newHotelName));
                        System.out.println(newHotelName + " was added into the system.");
                    }
                    else{
                        System.out.println("Hotel name is already in use.");
                    }
                }
                case 2 -> { //Delete Hotel UI
                    if (!hotelList.isEmpty()){ //only works if there is at least one hotel in the system
                        int delIndex = -1;
                        while(delIndex == -1){ //loops until user inputs the name of an existing hotel
                            System.out.println("Input name of Hotel to delete: ");
                            String delHotelName = str.nextLine();
                            for (int i = 0; i < hotelList.size(); i++){ 
                                if (delHotelName.equals(hotelList.get(i).getHotelName())){
                                    delIndex = i;
                                }
                            }
                        }
                        if (hotelList.get(delIndex).getReserveList().size() < 1){ //gives user the option to delete this hotel if the hotel has no reservations
                            System.out.println("Input Y to confirm this change. Type any other character to cancel this change");
                            char confirmChange = cha.next().charAt(0);
                            if (confirmChange == 'Y' || confirmChange == 'y'){
                                System.out.println(hotelList.get(delIndex).getHotelName() + " was deleted from the system.");
                                hotelList.remove(delIndex);
                            }
                        }
                        else{
                            System.out.println("You cannot remove hotels with reservations.");
                        }
                    }
                    else{
                        System.out.println("There are no hotels available to delete.");
                    }     
                }
                case 3 -> { //View Hotel UI
                    int viewAction = -1;
                    if (!hotelList.isEmpty()){ //only works if there is at least one hotel to view
                        int viewIndex = -1;
                        while(viewIndex == -1){ //loops until user inputs the name of an existing hotel
                            System.out.println("Input name of Hotel to view: ");
                            String hotelView = str.nextLine();
                            for (int i = 0; i < hotelList.size(); i++){
                                if (hotelView.equals(hotelList.get(i).getHotelName())){
                                    viewIndex = i;
                                }
                            }
                        }
                        Hotel hotelToView = hotelList.get(viewIndex);
                        while (viewAction != 4){ //keeps looping until 4 (Return to Main Menu) is inputted
                            System.out.println("Selected Hotel: " + hotelToView.getHotelName());
                            System.out.println("Total Number of Rooms: " + hotelToView.getNumOfRooms());
                            System.out.printf("Total Earnings for July 2024: $%.2f \n", hotelToView.getTotalEarnings());
                            System.out.println("Input the number of your desired course of action.");
                            System.out.println("[1] Check Rooms for Selected Date");
                            System.out.println("[2] Info about Selected Room");
                            System.out.println("[3] Info about Selected Reservation");
                            System.out.println("[4] Return to Main Menu");
                            viewAction = act.nextInt();
                            
                            switch (viewAction){
                            case 1 -> { //Check Rooms for Selected Date 
                                int month = 0;
                                int day = 0;
                                int year = 0;
                                while (day < 1 || day > 31){
                                    System.out.println("Input date (MM/DD/YYYY): ");
                                    String viewDate = str.nextLine();
                                    String[] data = viewDate.split("/");
                                    month = Integer.parseInt(data[0]);
                                    day = Integer.parseInt(data[1]);
                                    year = Integer.parseInt(data[2]);
                                }
                                int i, j, vacantCount, bookedCount = 0;
                                Room[] roomListCount = hotelToView.getRoomList();
                                if (hotelToView.getNumOfRooms() > 0){ //calculates number of booked rooms and vacant rooms
                                    for (i = 0; i < hotelToView.getNumOfRooms(); i++){
                                        for (j = 0; j < roomListCount[i].getDaysOccupied().size(); j++) {
                                            if (roomListCount[i].getDaysOccupied().get(j) == day){
                                                bookedCount++;
                                            }  
                                        } 
                                    }
                                    vacantCount = hotelToView.getNumOfRooms() - bookedCount;
                                }
                                else{
                                    vacantCount = hotelToView.getNumOfRooms();
                                }
                                //displays number of vacant and occupied rooms
                                System.out.println("Number of available rooms: " + vacantCount);
                                System.out.println("Number of booked rooms: " + bookedCount);
                                System.out.println(" ");
                            }
                            case 2 -> { //Info about Selected Room
                                int i;
                                int roomIndex = -1;
                                while (roomIndex == -1){
                                    System.out.println("Input Room Number: ");
                                    int roomCode = act.nextInt();
                                    for (i = 0; i < hotelToView.getNumOfRooms(); i++){ //finds the specific room in the system based on the roomName
                                        if (roomCode == hotelToView.getRoomList()[i].getRoomNumber()){
                                            roomIndex = i;
                                        }    
                                    }   
                                } //Displays information about selected Room
                                Room roomToView = hotelToView.getRoomList()[roomIndex];
                                System.out.println("Selected Room Number: " + roomToView.getRoomNumber());
                                System.out.printf("Selected Room Price per Night: %.2f \n", roomToView.getPrice());
                                if (roomToView instanceof DeluxeRoom)
                                    System.out.println("Type of Room: Deluxe");
                                else if (roomToView instanceof ExecutiveRoom)
                                    System.out.println("Type of Room: Executive");
                                else
                                    System.out.println("Type of Room: Standard");
                                String dateStart = "";
                                String dateFinish = "";
                                int occupied = -1;
                                for (i = 0; i < hotelToView.getReserveList().size(); i++){
                                    if (hotelToView.getReserveList().get(i).getRoomInfo() == roomToView){
                                        Reservation roomRes = hotelToView.getReserveList().get(i);
                                        dateStart = "7/" + roomRes.getCheckInDate().getDay() + "/2024";
                                        int finishDay = roomRes.getCheckOutDate().getDay() - 1;
                                        dateFinish = "7/" + finishDay + "/2024";
                                        occupied = 1;
                                    }
                                }
                                if (occupied == 1)
                                    System.out.println("This room is occupied from " + dateStart + " to " + dateFinish);
                                System.out.println(" ");
                            }
                            case 3 -> { //Info about Selected Reservation
                                int i;
                                int resIndex = -1;
                                while (resIndex == -1){
                                    System.out.println("Input Guest Name for Reservation: ");
                                    String resName = str.nextLine();
                                    for (i = 0; i < hotelToView.getReserveList().size(); i++){ //finds the specific reservation in the system based on guestName
                                        if (resName.equals(hotelToView.getReserveList().get(i).getGuestName())){
                                            resIndex = i;
                                        }    
                                    }   
                                } //Displays info about the selected Reservation
                                Reservation resToView = hotelToView.getReserveList().get(resIndex);
                                System.out.println("Reservation Guest Name: " + resToView.getGuestName());
                                System.out.println("Reservation Room Number: " + resToView.getRoomInfo().getRoomNumber());
                                if (resToView.getRoomInfo() instanceof DeluxeRoom)
                                    System.out.println("Type of Room: Deluxe");
                                else if (resToView.getRoomInfo() instanceof ExecutiveRoom)
                                    System.out.println("Type of Room: Executive");
                                else
                                    System.out.println("Type of Room: Standard");
                                System.out.println("Reservation Check In Date: " + resToView.getCheckInDate().getMonth() + "/" + resToView.getCheckInDate().getDay() + "/" + resToView.getCheckInDate().getYear());
                                System.out.println("Reservation Check Out Date: " + resToView.getCheckOutDate().getMonth() + "/" + resToView.getCheckOutDate().getDay() + "/" + resToView.getCheckOutDate().getYear());
                                System.out.printf("Reservation Total Price: $%.2f \n", resToView.getTotalPrice());
                                System.out.printf("Reservation Price per Night: $%.2f \n", resToView.getRoomInfo().getPrice());
                                System.out.println(" ");
                            }
                            }
                        }
                    }
                    else
                        System.out.println("There are no hotels available to view.");
                }
                case 4 -> { //Manage Hotel UI
                    int manageAction = -1;
                    if (!hotelList.isEmpty()){
                        int manageIndex = -1;
                        while(manageIndex == -1){
                            System.out.println("Input name of Hotel to manage: ");
                            String hotelManage = str.nextLine();
                            for (int i = 0; i < hotelList.size(); i++){
                                if (hotelManage.equals(hotelList.get(i).getHotelName())){
                                    manageIndex = i;
                                }
                            }
                        }
                        while (manageAction != 7){ //loops until 6 (Return to Main Menu) is inputed
                            System.out.println("Selected Hotel: " + hotelList.get(manageIndex).getHotelName());
                            System.out.println("Input the number of your desired course of action.");
                            System.out.println("[1] Change Hotel Name");
                            System.out.println("[2] Add a Room");
                            System.out.println("[3] Remove a Room");
                            System.out.println("[4] Update Base Price");
                            System.out.println("[5] Remove Reservation");
                            System.out.println("[6] Date Price Modifier");
                            System.out.println("[7] Return to Main Menu");
            
                            manageAction = act.nextInt();

                            switch (manageAction){
                                case 1 -> { //Change Hotel Name UI
                                    System.out.println("Curent Name: " + hotelList.get(manageIndex).getHotelName());
                                    System.out.println("Input new Hotel Name: ");
                                    String replaceName = str.nextLine();
                                    int i, usedCheck = 0;
                                    for (i = 0; i < hotelList.size(); i++){ //checks if new inputted hotel name is unique
                                        if (replaceName.equals(hotelList.get(i).getHotelName()) == true)
                                            usedCheck++;
                                    }
                                    if (usedCheck == 0){ //gives the user the option to change this hotel's name
                                        System.out.println("Former Hotel Name (" + hotelList.get(manageIndex).getHotelName() + ") will be changed to " + "replaceName" + ".");
                                        System.out.println("Input Y to confirm this change. Type any other character to cancel this change. ");
                                        char confirmChange = cha.next().charAt(0);
                                        if (confirmChange == 'Y' || confirmChange == 'y'){
                                            hotelList.get(manageIndex).setHotelName(replaceName);
                                            System.out.println("Name change was successful.");
                                        }
                                        else
                                            System.out.println("Attempt to change Hotel Name of" + hotelList.get(manageIndex).getHotelName() + " was cancelled.");
                                    }
                                    else{
                                        System.out.println(replaceName + " cannot be used, as it is already the name of another existing hotel.");
                                    }
                                }
                                case 2 -> { //Add Rooms UI
                                    Hotel hotelAddIn = hotelList.get(manageIndex);
                                    String typeAdd = " ";
                                    while(!typeAdd.equals("Standard") && !typeAdd.equals("Deluxe") && !typeAdd.equals("Executive")){
                                        System.out.println("What kind of room do you want to add?"); 
                                        System.out.println("Choose between Standard, Deluxe, or Executive. "); 
                                        typeAdd = str.nextLine();
                                    }
                                    int roomsToAdd = 0, i;
                                    System.out.println("Current Number of Rooms: " + hotelList.get(manageIndex).getNumOfRooms());
                                    while (roomsToAdd < 1 || roomsToAdd + hotelAddIn.getNumOfRooms() > 50){
                                        System.out.printf("How many %s rooms would you like to add? ", typeAdd); 
                                        roomsToAdd = act.nextInt();
                                    }
                                    //gives the user the option to add their desired number of rooms to the end of the roomList
                                    System.out.print("Input Y to confirm this change. Type any other character to cancel this change. ");
                                    char confirmChange = cha.next().charAt(0);
                                    if (confirmChange == 'Y' || confirmChange == 'y'){
                                        int roomMark = hotelAddIn.getNumOfRooms();
                                        Room[] roomList = hotelAddIn.getRoomList();
                                        switch (typeAdd) {
                                            case "Standard" -> {
                                                for (i = 1; i <= roomsToAdd; i++){ //adds new Standard Rooms to the end of the roomList
                                                    int latestRoom;
                                                    if (roomMark == 0){
                                                        latestRoom = 100;
                                                    }
                                                    else{
                                                        latestRoom = roomList[roomMark-1].getRoomNumber();
                                                    }
                                                    roomList[roomMark+i-1] = new Room(latestRoom+i, hotelAddIn.getBasePrice());
                                                }
                                                hotelAddIn.setNumOfRooms(hotelAddIn.getNumOfRooms() + roomsToAdd);
                                                System.out.println(roomsToAdd + " Standard Rooms have been added to " + hotelAddIn.getHotelName());
                                            }
                                            case "Deluxe" -> {
                                                for (i = 1; i <= roomsToAdd; i++){ //adds new Standard Rooms to the end of the roomList
                                                    int latestRoom;
                                                    if (roomMark == 0){
                                                        latestRoom = 100;
                                                    }
                                                    else{
                                                        latestRoom = roomList[roomMark-1].getRoomNumber();
                                                    }
                                                    roomList[roomMark+i-1] = new DeluxeRoom(latestRoom+i, hotelAddIn.getBasePrice());
                                                }   
                                                hotelAddIn.setNumOfRooms(hotelAddIn.getNumOfRooms() + roomsToAdd);
                                                System.out.println(roomsToAdd + " Deluxe Rooms have been added to " + hotelAddIn.getHotelName());
                                            }
                                            case "Executive" -> {
                                                for (i = 1; i <= roomsToAdd; i++){ //adds new Standard Rooms to the end of the roomList
                                                    int latestRoom;
                                                    if (roomMark == 0){
                                                        latestRoom = 100;
                                                    }
                                                    else{
                                                        latestRoom = roomList[roomMark-1].getRoomNumber();
                                                    }
                                                    roomList[roomMark+i-1] = new ExecutiveRoom(latestRoom+i, hotelAddIn.getBasePrice());
                                                }   
                                                hotelAddIn.setNumOfRooms(hotelAddIn.getNumOfRooms() + roomsToAdd);
                                                System.out.println(roomsToAdd + " Executive Rooms have been added to " + hotelAddIn.getHotelName());
                                            }
                                        }
                                    }
                                    else{
                                        System.out.print(" was cancelled." + "Attempt to add rooms to " + hotelList.get(manageIndex).getHotelName());
                                    }
                                }
                                case 3 -> { //Delete a Room UI
                                    Hotel hotelDelIn = hotelList.get(manageIndex);
                                    if (hotelDelIn.getNumOfRooms() >= 1){
                                        System.out.println("Current Number of Rooms: " + hotelList.get(manageIndex).getNumOfRooms());
                                        int roomDelIndex = -1;
                                        while (roomDelIndex == -1){
                                            System.out.println("Input Room Number to Delete: ");
                                            int inputRoomNum = act.nextInt();
                                            int reserveCount = 0;
                                            for (int i = 0; i < hotelDelIn.getReserveList().size(); i++){ //checks if the selected room has an active reservation
                                                if (inputRoomNum == hotelDelIn.getReserveList().get(i).getRoomInfo().getRoomNumber()){
                                                    reserveCount++;
                                                }
                                            }
                                            if (reserveCount == 0){ //locates the index of selected room if it has no active reservations
                                                for (int j = 0; j < hotelDelIn.getNumOfRooms(); j++){
                                                    if (inputRoomNum == hotelDelIn.getRoomList()[j].getRoomNumber()){
                                                        roomDelIndex = j;
                                                    }
                                                }
                                            } //gives the user the option to delete the selected room
                                            System.out.println("You are about to delete room number " + hotelDelIn.getRoomList()[roomDelIndex].getRoomNumber());
                                            System.out.print("Input Y to confirm this change. Type any other character to cancel this change. ");
                                            char confirmChange = cha.next().charAt(0);
                                            if (confirmChange == 'Y' || confirmChange == 'y'){
                                                System.out.println("Room " + hotelDelIn.getRoomList()[roomDelIndex].getRoomNumber() + " has been deleted from this hotel.");
                                                hotelDelIn.setNumOfRooms(hotelDelIn.getNumOfRooms()-1);
                                                for (int n = roomDelIndex; n < hotelDelIn.getNumOfRooms(); n++) { //shifts other rooms after deleted room one position to the left in the array
                                                    hotelDelIn.getRoomList()[n] = hotelDelIn.getRoomList()[n+1];
                                                }
                                            }
                                            else{
                                                System.out.println("Attempt to delete Room " + hotelDelIn.getRoomList()[roomDelIndex].getRoomNumber() + " was cancelled.");
                                            }
                                        }
                                    }
                                    else{
                                        System.out.println("There are no rooms available to delete.");
                                    }
                                }
                                case 4 -> { //Update Base Price UI
                                    Hotel priceHotel = hotelList.get(manageIndex);
                                    if (priceHotel.getReserveList().isEmpty()){ //only works if there are no active reservations
                                        System.out.println("Curent Base Price for " + priceHotel.getHotelName() + ": $" + priceHotel.getBasePrice());
                                        System.out.println("Input new Base Price: ");
                                        double newBasePrice = 99.0f;
                                        while (newBasePrice < 100.0){ //stops looping when inputted basePrice is at least 100
                                            newBasePrice = doub.nextDouble();
                                            if (newBasePrice >= 100.0){
                                                System.out.println("Input Y to confirm this change. Type any other character to cancel this change. ");
                                                char confirmChange = cha.next().charAt(0);
                                                if (confirmChange == 'Y' || confirmChange == 'y'){
                                                    priceHotel.setBasePrice(newBasePrice); //changes the basePrice of the whole Hotel
                                                    for (int i = 0; i < priceHotel.getNumOfRooms(); i++){ //changes the price of each individual Room to the new basePrice
                                                        priceHotel.getRoomList()[i].setPrice(newBasePrice);
                                                    }
                                                    System.out.println("Base Price of " + priceHotel.getHotelName() + " is now $" + newBasePrice);
                                                }
                                                else{
                                                    System.out.println("Attempt to change Base Price of " + priceHotel.getHotelName() + " was cancelled.");
                                                }
                                            }
                                            else{
                                                System.out.println("New Base Price must be at least $100. Please try again.");
                                            }
                                        }
                                    }
                                    else{
                                        System.out.println("You cannot change the base price of this hotel becaue it has at least one active reservation.");
                                    }
                                }
                                case 5 -> { //Remove Reservation UI
                                    ArrayList<Reservation> hotelResList = hotelList.get(manageIndex).getReserveList();
                                    Hotel removeResHotel = hotelList.get(manageIndex);
                                    int removeResIndex = -1;
                                    
                                    if (!hotelResList.isEmpty()){ //only works if there is at least one active reservation
                                        while (removeResIndex == -1){
                                            System.out.println("Input Name of Guest to remove their reservation: ");
                                            String removeGuest = str.nextLine();
                                            for (int i = 0; i < hotelResList.size(); i++){ //finds the specific reservation in the system based on guestName
                                                if (removeGuest.equals(hotelResList.get(i).getGuestName())){
                                                    removeResIndex = i;
                                                }    
                                            }   
                                        }
                                        int roomModifyIndex = -1; //finds the room connected to the reservation to delete
                                        for (int k = 0; k < hotelList.get(manageIndex).getNumOfRooms() && roomModifyIndex == -1; k++){
                                            if (removeResHotel.getRoomList()[k].getRoomNumber() == hotelResList.get(removeResIndex).getRoomInfo().getRoomNumber()){
                                                roomModifyIndex = k;
                                            }
                                        } //gives the user the option to deletw thw selected reservation
                                        System.out.println("Input Y to confirm this change. Type any other character to cancel this change. ");
                                        char confirmChange = cha.next().charAt(0);
                                        if (confirmChange == 'Y' || confirmChange == 'y'){ //removes the contents of daysOccupied for the afected Room
                                            for (int j = 0; j < removeResHotel.getRoomList()[roomModifyIndex].getDaysOccupied().size(); j++){
                                                removeResHotel.getRoomList()[roomModifyIndex].getDaysOccupied().remove(j);
                                            }
                                            removeResHotel.setTotalEarnings(removeResHotel.getTotalEarnings()-hotelResList.get(removeResIndex).getTotalPrice());
                                            System.out.println("Reservation for Room Number " + hotelResList.get(removeResIndex).getRoomInfo().getRoomNumber() + " has been removed from this hotel.");
                                            hotelResList.remove(removeResIndex); //removes the reservation from the system
                                        }
                                    }
                                    else{
                                        System.out.println("This hotel has no reservations to delete.");
                                    }
                                    //System.out.println("");
                                }
                                case 6 -> { //Date Price Modifier
                                    Hotel rateHotel = hotelList.get(manageIndex);
                                    if (rateHotel.getReserveList().isEmpty()){ //Allows the user to input their desired date to modify if there are no active reservations
                                        System.out.println("Input day in July to modify price rate: ");
                                        int dayRate = act.nextInt();
                                        System.out.println("Current Price Rate for July " + dayRate + ", 2024: " + rateHotel.getPriceRates()[dayRate-1]);
                                        double newRate = -1.0f;
                                        while(newRate < 0.50f || newRate > 1.50f){
                                            System.out.println("Input new Price Rate (between 0.50 and 1.50): ");
                                            newRate = doub.nextDouble();
                                        } //Gives the user the option to change the price for the date that they chose
                                        System.out.println("Input Y to confirm this change. Type any other character to cancel this change. ");
                                        char confirmChange = cha.next().charAt(0);
                                        if (confirmChange == 'Y' || confirmChange == 'y'){
                                            rateHotel.getPriceRates()[dayRate-1] = newRate; 
                                            System.out.println("Price Rate for July " + dayRate + ", 2024 has been changed to " + newRate);
                                        }
                                        else{
                                            System.out.println("Attempt to change Price Rate for July " + dayRate + ", 2024 was cancelled.");
                                        }
                                    }
                                    else{
                                        System.out.println("You cannot change the price of the dates of this hotel becaue it has at least one active reservation.");
                                    }
                                }
                            }
                        }
                    }
                    else
                        System.out.println("There are no hotels available to manage.");
                }
                case 5 -> { //Create Booking UI
                    if (!hotelList.isEmpty()){ //only works if there is at least one Hotel in the system
                        System.out.println("Book a Room for Current Month (July 2024)");
                        int checkInDay = 31;
                        int checkOutDay = 1;
                        int hotelResIndex = -1;
                        while(hotelResIndex == -1){ //loops until user inputs the name of an existing Hotel
                            System.out.println("Input name of Hotel to Make Booking in: ");
                            String hotelResName = str.nextLine();
                            for (int i = 0; i < hotelList.size(); i++){ 
                                Hotel hotelCheck = hotelList.get(i);
                                if (hotelResName.equals(hotelCheck.getHotelName()) && hotelCheck.getNumOfRooms() > 0){
                                    hotelResIndex = i;
                                }
                            }   
                        }
                        Hotel hotelBook = hotelList.get(hotelResIndex);
                        Room[] roomListBook = hotelList.get(hotelResIndex).getRoomList();
                        int bookedCheck = 0;

                        while (checkInDay >= 31 || checkInDay < 1){ //loops until user inputs checkInDate that is less than 31
                            System.out.print("Input Day in July 2024 for Check In: ");
                            checkInDay = act.nextInt();
                        }
                        Date dateIn = new Date(7, checkInDay, 2024);
                        while (checkOutDay <= 1 || checkOutDay > 31 || checkOutDay < checkInDay){ //loops until user inputs checkOutDate that is greater than 1
                            System.out.print("Input Day in July 2024 for Check Out: ");
                            checkOutDay = act.nextInt();
                        }
                        Date dateOut = new Date(7, checkOutDay, 2024);

                        for (int i = 0; i < hotelBook.getNumOfRooms(); i++){ //counts how many rooms in the hotel are already booked
                            for (int j = 0; j < roomListBook[i].getDaysOccupied().size(); j++){
                                if (roomListBook[i].getDaysOccupied().get(j) >= checkInDay && roomListBook[i].getDaysOccupied().get(j) < checkOutDay){
                                    bookedCheck++;
                                }
                            }
                        }

                        if (bookedCheck != hotelBook.getNumOfRooms()){ //only works if there is at least one vacant room
                            System.out.println("Input Name of Guest: ");
                            String nameGuest = str.nextLine();
                            double totalCost = 0;
                            int roomType = 0;
                            while (roomType < 1 || roomType > 3){ //Allows the user to select the kind of room they want
                                System.out.println("What kind of Room do you want? ");
                                System.out.println("[1]Standard\t [2]Deluxe\t [3]Executive");
                                roomType = act.nextInt();
                            }
                            Room roomBook = null;
                            int freeCount = 0;
                            switch (roomType) {
                                case 1 -> { //for picking a Standard Room
                                    for (int i = 0; i < hotelBook.getNumOfRooms() && roomBook == null; i++) { //finds the first available Standard Room in the Hotel
                                        if (roomListBook[i].getDaysOccupied().isEmpty() && !(roomListBook[i] instanceof DeluxeRoom) && !(roomListBook[i] instanceof ExecutiveRoom)){ //works if there are no reservations in the Hotel
                                            for (int n = checkInDay; n <= checkOutDay-1; n++){
                                                roomListBook[i].getDaysOccupied().add(n);
                                            }
                                            roomBook = roomListBook[i];
                                        }
                                        else{ //finds a Standard Room that is not connected to any existing Reservation
                                            for (int j = 0; j < roomListBook[i].getDaysOccupied().size(); j++){
                                                if (roomListBook[i].getDaysOccupied().get(j) < checkInDay && roomListBook[i].getDaysOccupied().get(j) >= checkOutDay && !(roomListBook[i] instanceof DeluxeRoom) && !(roomListBook[i] instanceof ExecutiveRoom)){
                                                    freeCount++;
                                                }
                                            }
                                            if (freeCount == checkOutDay-checkInDay){
                                                for (int n = checkInDay; n <= checkOutDay-1; n++){
                                                    roomListBook[i].getDaysOccupied().add(n);
                                                }
                                                roomBook = roomListBook[i];
                                            }
                                        }
                                    }
                                }
                                case 2 -> { //for picking a Deluxe Room
                                    for (int i = 0; i < hotelBook.getNumOfRooms() && roomBook == null; i++) { //finds the first available Deluxe Room in the Hotel
                                        if (roomListBook[i].getDaysOccupied().isEmpty() && (roomListBook[i] instanceof DeluxeRoom)){ //works if there are no reservations in the Hotel
                                            for (int n = checkInDay; n <= checkOutDay-1; n++){
                                                roomListBook[i].getDaysOccupied().add(n);
                                            }
                                            roomBook = roomListBook[i];
                                        }
                                        else{ //finds a Deluxe Room that is not connected to any existing Reservation
                                            for (int j = 0; j < roomListBook[i].getDaysOccupied().size(); j++){
                                                if (roomListBook[i].getDaysOccupied().get(j) < checkInDay && roomListBook[i].getDaysOccupied().get(j) >= checkOutDay && (roomListBook[i] instanceof DeluxeRoom)){
                                                    freeCount++;
                                                }
                                            }
                                            if (freeCount == checkOutDay-checkInDay){
                                                for (int n = checkInDay; n <= checkOutDay-1; n++){
                                                    roomListBook[i].getDaysOccupied().add(n);
                                                }
                                                roomBook = roomListBook[i];
                                            }
                                        }
                                    }
                                }
                                case 3 -> { //for picking an Executive Room
                                    for (int i = 0; i < hotelBook.getNumOfRooms() && roomBook == null; i++) { //finds the first available Executive Room in the Hotel
                                        if (roomListBook[i].getDaysOccupied().isEmpty() && (roomListBook[i] instanceof ExecutiveRoom)){ //works if there are no reservations in the Hotel
                                            for (int n = checkInDay; n <= checkOutDay-1; n++){
                                                roomListBook[i].getDaysOccupied().add(n);
                                            }
                                            roomBook = roomListBook[i];
                                        }
                                        else{ //finds an Executive Room that is not connected to any existing Reservation
                                            for (int j = 0; j < roomListBook[i].getDaysOccupied().size(); j++){
                                                if (roomListBook[i].getDaysOccupied().get(j) < checkInDay && roomListBook[i].getDaysOccupied().get(j) >= checkOutDay && (roomListBook[i] instanceof ExecutiveRoom)){
                                                    freeCount++;
                                                }
                                            }
                                            if (freeCount == checkOutDay-checkInDay){
                                                for (int n = checkInDay; n <= checkOutDay-1; n++){
                                                    roomListBook[i].getDaysOccupied().add(n);
                                                }
                                                roomBook = roomListBook[i];
                                            }
                                        }
                                    }
                                }
                            }
                            for (int i = checkInDay; i < checkOutDay; i++){ //calculates the total Reservation price by getting the summation of the product of the price per day by the day's price rate
                                totalCost += roomBook.getPrice()*hotelBook.getPriceRates()[i];
                            }
                            System.out.println("Would you like to input a discount code? Write Y for yes. Type any other character to decline. "); 
                            char addCode = cha.next().charAt(0); //gives the user the option to input a discount code
                            if (addCode == 'Y' || addCode == 'y'){ 
                                int codeFound = -1;
                                String code = "";
                                while (codeFound != 1){
                                    System.out.println("Input Discount Code: "); //Makes the user input a discount code; keeps looping until user inputs one of the 3 available codes
                                    code = str.nextLine();
                                    if (code.equals("I_WORK_HERE") || code.equals("STAY4_GET1") || code.equals("PAYDAY"))
                                        codeFound = 1;  
                                }
                                if (code.equals("I_WORK_HERE")){ //Reduces the total price by 10%
                                    totalCost *= 0.90;
                                    System.out.println("The price of your reservation has been reduced by 10%.");
                                }
                                    
                                else if (code.equals("STAY4_GET1")){ //Excludes the first day from the total price if the Reservation covers at least 5 days
                                    if (dateOut.getDay()-dateIn.getDay() >= 5){
                                        totalCost -= hotelList.get(hotelResIndex).getBasePrice();
                                        System.out.println("The first day of your reservation was excluded from its total price.");
                                    }
                                    else
                                        System.out.println("Discount code failed. Your reservation does not contain 5 or more days.");
                                }
                                else if (code.equals("PAYDAY")){ //Reduces the total price by 7% if the reservation covers either day 15 or 30 (but not as the check-out day)
                                    int foundIndex = -1;
                                    for (int i = 0; i < roomBook.getDaysOccupied().size(); i++){
                                        if (roomBook.getDaysOccupied().get(i) == 15 || roomBook.getDaysOccupied().get(i) == 30)
                                            foundIndex = 1;
                                    }
                                    if (foundIndex == 1){
                                        totalCost *= 0.93;
                                        System.out.println("The price of your reservation has been reduced by 7%.");
                                    }
                                    else
                                        System.out.println("Discount code failed. Your reservation does not cover day 15 nor 30.");
                                }
                            }
                            else{
                                System.out.println("No discount was added to this reservation");
                            } 
                            //creates the Reservation and adds to the totalEarnings of the Hotel
                            hotelList.get(hotelResIndex).getReserveList().add(new Reservation(nameGuest, dateIn, dateOut, roomBook, totalCost));
                            System.out.println(nameGuest +", you booked room no. " + roomBook.getRoomNumber() + " in " + hotelBook.getHotelName() + " from 7/" + checkInDay + "/2024 to 7/" + checkOutDay + "/2024");
                            System.out.printf("The total price of your reservation is $%.2f \n", totalCost);
                            hotelList.get(hotelResIndex).setTotalEarnings(hotelList.get(hotelResIndex).getTotalEarnings()+totalCost);
                        }
                        else{
                            System.out.println(hotelBook.getHotelName() + " is currently fully booked.");
                        }
                        
                    }
                    else
                    System.out.println("There are no hotels available to book.");
                }
            }
            System.out.println("");
        }
        //This marks the closing of the program
        System.out.println("Thank you for using Aldrin's Hotel Reservation System!");
        System.out.println("Have a great day!");
    }
}
