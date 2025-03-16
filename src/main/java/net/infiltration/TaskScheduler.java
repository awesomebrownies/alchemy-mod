package net.infiltration;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TaskScheduler {
    private static final Map<Runnable, Integer> scheduledTasks = new HashMap<>();

    public static void init(){
        ServerTickEvents.END_SERVER_TICK.register(TaskScheduler::onServerTick);
    }

    public static void scheduleTask(Runnable task, int delayTicks){
        scheduledTasks.put(task, delayTicks);
    }

    private static void onServerTick(MinecraftServer server){
        Iterator<Map.Entry<Runnable, Integer>> iterator = scheduledTasks.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Runnable, Integer> entry = iterator.next();
            int remainingTicks = entry.getValue() - 1;
            if(remainingTicks <= 0){
                entry.getKey().run();
                iterator.remove();
            }else{
                entry.setValue(remainingTicks);
            }
        }
    }
}
