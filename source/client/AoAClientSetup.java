package net.tslat.aoa3.client;

import net.minecraft.client.gui.screens.inventory.MerchantScreen;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.tslat.aoa3.advent.AdventOfAscension;
import net.tslat.aoa3.client.event.ClientEventHandler;
import net.tslat.aoa3.client.gui.container.*;
import net.tslat.aoa3.client.gui.hud.BossBarRenderer;
import net.tslat.aoa3.client.gui.hud.HealthStatusRenderer;
import net.tslat.aoa3.client.gui.hud.RecoilRenderer;
import net.tslat.aoa3.client.gui.hud.XpParticlesRenderer;
import net.tslat.aoa3.client.gui.overlay.ScopeOverlayRenderer;
import net.tslat.aoa3.client.gui.overlay.ScreenEffectRenderer;
import net.tslat.aoa3.client.model.ModelProperties;
import net.tslat.aoa3.client.particle.*;
import net.tslat.aoa3.client.render.AoAGuiElementRenderers;
import net.tslat.aoa3.client.render.dimension.AoADimensionRenderEffects;
import net.tslat.aoa3.client.render.entity.misc.OccultBlockRenderer;
import net.tslat.aoa3.client.render.shader.AoAPostProcessing;
import net.tslat.aoa3.common.menu.MendingTableMenu;
import net.tslat.aoa3.common.menu.WhitewashingTableMenu;
import net.tslat.aoa3.common.registration.AoAMenus;
import net.tslat.aoa3.common.registration.AoAParticleTypes;
import net.tslat.aoa3.common.registration.block.AoABlocks;
import net.tslat.aoa3.data.client.AoAResourceReloadListeners;
import net.tslat.aoa3.integration.IntegrationManager;

import java.util.function.Consumer;

public final class AoAClientSetup {
    public static void init() {
        AoAEntityRendering.init();
        ClientEventHandler.init();
        AoAPostProcessing.init();
        AoAGuiElementRenderers.init();
        AoAKeybinds.init();
        AoAResourceReloadListeners.init();
        AoAArmPoses.init();
        ScopeOverlayRenderer.init();
        XpParticlesRenderer.init();
        ScreenEffectRenderer.init();
        AoADimensionRenderEffects.init();
        AoATintHandling.init();
        BossBarRenderer.init();
        RecoilRenderer.init();
        HealthStatusRenderer.init();
        OccultBlockRenderer.init();

        AdventOfAscension.getModEventBus().addListener(EventPriority.NORMAL, false, RegisterParticleProvidersEvent.class, AoAClientSetup::registerParticleFactories);
        AdventOfAscension.getModEventBus().addListener(EventPriority.NORMAL, false, RegisterMenuScreensEvent.class, AoAClientSetup::registerMenuScreens);
    }

    public static void postInit(Consumer<Runnable> workQueue) {
        workQueue.accept(() -> {
            AoABlocks.getRegisteredLiquidsForRenderTypes().forEach(ClientOperations::applyFluidRenderType);
            ModelProperties.init();
            AoAGuiElementRenderers.lateInit();
            IntegrationManager.clientInit();
        });
    }

    private static void registerMenuScreens(RegisterMenuScreensEvent ev) {
        ev.register(AoAMenus.DIVINE_STATION.get(), DivineStationScreen::new);
        ev.register(AoAMenus.MENDING_TABLE.get(), Generic2SlotContainerScreen<MendingTableMenu>::new);
        ev.register(AoAMenus.WHITEWASHING_TABLE.get(), Generic2SlotContainerScreen<WhitewashingTableMenu>::new);
        ev.register(AoAMenus.FRAME_BENCH.get(), FrameBenchScreen::new);
        ev.register(AoAMenus.INFUSION_TABLE.get(), InfusionTableScreen::new);
        ev.register(AoAMenus.IMBUING_CHAMBER.get(), ImbuingChamberScreen::new);
        ev.register(AoAMenus.TRADER.get(), MerchantScreen::new);
        ev.register(AoAMenus.BANKER.get(), BankerScreen::new);
        ev.register(AoAMenus.CORRUPTED_TRAVELLER.get(), CorruptedTravellerScreen::new);
    }

    private static void registerParticleFactories(RegisterParticleProvidersEvent ev) {
        ev.registerSpriteSet(AoAParticleTypes.PORTAL_FLOATER.get(), PortalFloaterParticle.Factory::new);
        ev.registerSpriteSet(AoAParticleTypes.SPARKLER.get(), SparklerParticle.Factory::new);
        ev.registerSpriteSet(AoAParticleTypes.FLICKERING_SPARKLER.get(), FlickeringSparklerParticle.Factory::new);
        ev.registerSpriteSet(AoAParticleTypes.LINGERING_SPARKLER.get(), LingeringSparklerParticle.Factory::new);
        ev.registerSpriteSet(AoAParticleTypes.RAINBOW_SPARKLER.get(), RainbowSparklerParticle.Factory::new);
        ev.registerSpriteSet(AoAParticleTypes.SWIRLY.get(), SwirlyParticle.Factory::new);
        ev.registerSpecial(AoAParticleTypes.FLOATING_ITEM_FRAGMENT.get(), new FloatingItemFragmentParticle.Factory());
        ev.registerSpriteSet(AoAParticleTypes.FREEZING_SNOWFLAKE.get(), FreezingSnowflakeParticle.Factory::new);
        ev.registerSpriteSet(AoAParticleTypes.BURNING_FLAME.get(), BurningFlameParticle.Factory::new);
        ev.registerSpriteSet(AoAParticleTypes.SANDSTORM.get(), SandstormParticle.Factory::new);
        ev.registerSpriteSet(AoAParticleTypes.ORB.get(), OrbParticle.Factory::new);
        ev.registerSpriteSet(AoAParticleTypes.FIRE_AURA.get(), FireAuraParticle.Factory::new);
        //ev.registerSpecial(AoAParticleTypes.BEAM.get(), new BeamParticle.Factory());
    }
}
