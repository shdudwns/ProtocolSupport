package protocolsupport.protocol.packet.middleimpl.serverbound.play.v_13;

import io.netty.buffer.ByteBuf;
import protocolsupport.protocol.packet.middle.serverbound.play.MiddleNameItem;
import protocolsupport.protocol.serializer.StringSerializer;

public class NameItem extends MiddleNameItem {

	@Override
	public void readFromClientData(ByteBuf clientdata) {
		name = StringSerializer.readString(clientdata, connection.getVersion());
	}

}
