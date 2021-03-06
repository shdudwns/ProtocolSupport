package protocolsupport.protocol.packet.middle.serverbound.login;

import protocolsupport.protocol.packet.ServerBoundPacket;
import protocolsupport.protocol.packet.middle.ServerBoundMiddlePacket;
import protocolsupport.protocol.packet.middleimpl.ServerBoundPacketData;
import protocolsupport.protocol.serializer.VarNumberSerializer;
import protocolsupport.utils.recyclable.RecyclableCollection;
import protocolsupport.utils.recyclable.RecyclableSingletonList;

public abstract class MiddleLoginCustomPayload extends ServerBoundMiddlePacket {

	protected int id;
	protected byte[] data;

	@Override
	public RecyclableCollection<ServerBoundPacketData> toNative() {
		ServerBoundPacketData creator = ServerBoundPacketData.create(ServerBoundPacket.LOGIN_CUSTOM_PAYLOAD);
		VarNumberSerializer.writeVarInt(creator, id);
		creator.writeBoolean(data != null);
		if (data != null) {
			creator.writeBytes(data);
		}
		return RecyclableSingletonList.create(creator);
	}

}
