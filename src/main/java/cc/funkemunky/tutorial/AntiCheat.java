package cc.zonal-anticheat;

import cc.Zonal-anticheat.checks.CheckManager;
import cc.Zonal-anticheat.data.DataManager;
import cc.Zonal-anticheat.events.JoinQuitEvents;
import cc.Zonal-anticheat.events.MoveEvents;
import cc.Zonal-anticheat.utilities.ReflectionUtils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class AntiCheat extends JavaPlugin {

    private static AntiCheat instance;
    private CheckManager checkManager;
    private DataManager dataManager;

    @Override
    public void onEnable() {
        instance = this;
        checkManager = new CheckManager();
        dataManager = new DataManager();

        new ReflectionUtils();

        Bukkit.getPluginManager().registerEvents(new MoveEvents(), this);
        Bukkit.getPluginManager().registerEvents(new JoinQuitEvents(), this);
    }

    public static AntiCheat getInstance() {
        return instance;
    }

    public CheckManager getCheckManager() {
        return checkManager;
    }

    public DataManager getDataManager() {
        return dataManager;
    }
}
