package protocolsupport.protocol.packet.middleimpl.clientbound.login.v_8_9r1_9r2_10_11_12r1_12r2_13;

import protocolsupport.protocol.packet.ClientBoundPacket;
import protocolsupport.protocol.packet.middle.clientbound.login.MiddleSetCompression;
import protocolsupport.protocol.packet.middleimpl.ClientBoundPacketData;
import protocolsupport.protocol.serializer.VarNumberSerializer;
import protocolsupport.utils.recyclable.RecyclableCollection;
import protocolsupport.utils.recyclable.RecyclableSingletonList;

public class SetCompression extends MiddleSetCompression {

	@Override
	public RecyclableCollection<ClientBoundPacketData> toData() {
		ClientBoundPacketData serializer = ClientBoundPacketData.create(ClientBoundPacket.LOGIN_SET_COMPRESSION_ID);
		VarNumberSerializer.writeVarInt(serializer, threshold);
		return RecyclableSingletonList.create(serializer);
	}

}
