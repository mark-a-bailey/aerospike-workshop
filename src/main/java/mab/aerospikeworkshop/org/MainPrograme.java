package mab.aerospikeworkshop.org;

import com.aerospike.client.AerospikeClient;
import mab.aerospikeworkshop.org.exercises.ExcerciseK2;
import mab.aerospikeworkshop.org.exercises.Exercise;

public class MainPrograme {

    public static void main(String[] args) {
        System.out.println("Starting client ...");
        AerospikeClient client = WorkshopAerospikeHelpers.getNewClient();
        if (client == null || !client.isConnected()) {
            System.out.println("\nERROR: Connection to Aerospike cluster failed! Please check the server settings and try again!");
        }
        else {
            System.out.println("Connection to Aerospike cluster succeeded!");
        }

        MainPrograme mp = new MainPrograme();
        mp.runExercises(client);

        if (client!=null && client.isConnected()) {
            System.out.println("Closing client");
            client.close();
        }
    }

    public void runExercises(AerospikeClient client) {
        Exercise exercise = new ExcerciseK2(client);

        //run exercise
        exercise.runExercise();
    }
}
