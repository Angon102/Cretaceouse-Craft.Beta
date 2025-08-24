package net.Ang.Practiceccmod.ToolActions;

import com.google.common.collect.Sets;
import net.minecraftforge.common.ToolAction;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ModToolActions {
    public static final ToolAction FOSSIL_CUTTER_HARVEST = ToolAction.get("fossil_cutter_harvest");


    public static final Set<ToolAction> DEFAULT_FOSSILCUTTER_ACTIONS = of(FOSSIL_CUTTER_HARVEST);


    private static Set<ToolAction> of(ToolAction... actions) {
        return Stream.of(actions).collect(Collectors.toCollection(Sets::newIdentityHashSet));
    }

}
