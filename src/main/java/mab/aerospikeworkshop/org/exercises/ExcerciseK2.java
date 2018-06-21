package mab.aerospikeworkshop.org.exercises;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import com.aerospike.client.policy.WritePolicy;
import mab.aerospikeworkshop.org.WorkshopAerospikeHelpers;

public class ExcerciseK2 implements Exercise {

    private AerospikeClient client;

    public ExcerciseK2(AerospikeClient client) {
        this.client = client;
    }

    public void runExercise() {
        WritePolicy writePolicy = WorkshopAerospikeHelpers.getDefaultWritePolicy();

        //start test writing
        Key key = new Key("test", "users", "mark");
        Bin bin1 = new Bin("username", "mab");

        client.put(writePolicy, key, bin1);
    }
}
