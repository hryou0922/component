package com.hry.java.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StreamsEffectivenessDemoTest {

    @Test
    public void streamsEffectivenessCost(){
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        StreamsEffectivenessDemo streamsEffectivenessDemo = new StreamsEffectivenessDemo();
        streamsEffectivenessDemo.executeStream(values);
        streamsEffectivenessDemo.executeParallelStream(values);
    }
}
