package net.infiltrationclient;

import net.fabricmc.api.ClientModInitializer;

public class AlchemyModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
//		KeybindSwapProxy.setClientImpl(new KeybindSwapImpl());
		net.infiltration.KeybindSwapProxy.setInstance(new KeybindSwapImpl());
	}
}