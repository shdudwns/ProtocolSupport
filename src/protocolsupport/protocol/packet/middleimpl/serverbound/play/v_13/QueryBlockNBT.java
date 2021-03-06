package protocolsupport.protocol.packet.middleimpl.serverbound.play.v_13;

import io.netty.buffer.ByteBuf;
import protocolsupport.protocol.packet.middle.serverbound.play.MiddleQueryBlockNBT;
import protocolsupport.protocol.serializer.PositionSerializer;
import protocolsupport.protocol.serializer.VarNumberSerializer;

public class QueryBlockNBT extends MiddleQueryBlockNBT {

	@Override
	public void readFromClientData(ByteBuf clientdata) {
		id = VarNumberSerializer.readVarInt(clientdata);
		PositionSerializer.readPositionTo(clientdata, position);
	}

}
