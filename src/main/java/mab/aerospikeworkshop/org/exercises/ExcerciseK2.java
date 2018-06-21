package mab.aerospikeworkshop.org.exercises;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.policy.WritePolicy;
import mab.aerospikeworkshop.org.WorkshopAerospikeHelpers;

public class ExcerciseK2 implements Exercise {

    private AerospikeClient client;

    public static final String username = "mark2";
    public static final String password = "123abc";

    public ExcerciseK2(AerospikeClient client) {
        this.client = client;
    }

    public void runExercise() {
        WritePolicy writePolicy = WorkshopAerospikeHelpers.getDefaultWritePolicy();

        //start test writing
        Key key = new Key("test", "users", username);
        Bin bin1 = new Bin("username", username);
        Bin bin2 = new Bin("password", password);
        Bin bin3 = new Bin("lasttweeted", 0);
        Bin bin4 = new Bin("tweetcount", 0);

        client.put(writePolicy, key, bin1, bin2, bin3, bin4);
    }
}
