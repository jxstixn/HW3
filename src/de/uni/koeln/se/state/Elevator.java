package de.uni.koeln.se.state;


public class Elevator {

    public static int current_Floor = 5;
    int dest_Floor;

    private Elv_States State = new Elv_States();

    public Elevator(int dest_floor) {
        State.Current_State = State.Idle;
        this.dest_Floor = dest_floor;
        System.out.println("*** Destination floor is: " + dest_Floor);
        if (dest_floor < 0 || dest_floor > 10) {
            System.out.println("--------------------------------------------");
            System.out.println("ERROR - Floor does not exist");
            System.out.println("--------------------------------------------");
        }else {
            if (current_Floor < dest_Floor) {
                go_up();
                arrive_atFloor();
            } else if (current_Floor > dest_Floor) {
                go_down();
                arrive_atFloor();
            } else if (current_Floor == dest_floor) {
                exit();
            }
        }
    }

    private void arrive_atFloor() {
        State.Current_State = State.Idle;
        System.out.println("--------------------------------------------");
        System.out.println("Arrived at destination");
        System.out.println("--------------------------------------------");
    }

    private void go_down() {
        State.Current_State = State.Moving_down;
        while (current_Floor > dest_Floor) {
            System.out.println("--------------------------------------------");
            System.out.println("Moving down");
            current_Floor--;
            System.out.println("Current Floor = " + current_Floor);
        }
    }

    private void go_up() {
        State.Current_State = State.Moving_up;
        while (current_Floor < dest_Floor) {
            System.out.println("--------------------------------------------");
            System.out.println("Moving up");
            current_Floor++;
            System.out.println("Current Floor = " + current_Floor);
        }
    }

    private void exit(){
        System.out.println("--------------------------------------------");
        System.out.println("Already at destination");
        System.out.println("--------------------------------------------");
    }
}
