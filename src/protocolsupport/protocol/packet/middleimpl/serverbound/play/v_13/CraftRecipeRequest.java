package protocolsupport.protocol.packet.middleimpl.serverbound.play.v_13;

import io.netty.buffer.ByteBuf;
import protocolsupport.protocol.packet.middle.serverbound.play.MiddleCraftRecipeRequest;
import protocolsupport.protocol.serializer.StringSerializer;

public class CraftRecipeRequest extends MiddleCraftRecipeRequest {

	@Override
	public void readFromClientData(ByteBuf clientdata) {
		windowId = clientdata.readUnsignedByte();
		recipeId = StringSerializer.readString(clientdata, connection.getVersion());
		all = clientdata.readBoolean();
	}

}
