package protocolsupport.protocol.packet.middleimpl.clientbound.play.v_13;

import protocolsupport.protocol.packet.ClientBoundPacket;
import protocolsupport.protocol.packet.middle.clientbound.play.MiddleTabComplete;
import protocolsupport.protocol.packet.middleimpl.ClientBoundPacketData;
import protocolsupport.protocol.serializer.ArraySerializer;
import protocolsupport.protocol.serializer.StringSerializer;
import protocolsupport.protocol.serializer.VarNumberSerializer;
import protocolsupport.protocol.utils.ProtocolVersionsHelper;
import protocolsupport.utils.recyclable.RecyclableCollection;
import protocolsupport.utils.recyclable.RecyclableSingletonList;

public class TabComplete extends MiddleTabComplete {

	@Override
	public RecyclableCollection<ClientBoundPacketData> toData() {
		ClientBoundPacketData serializer = ClientBoundPacketData.create(ClientBoundPacket.PLAY_TAB_COMPLETE_ID);
		VarNumberSerializer.writeVarInt(serializer, id);
		VarNumberSerializer.writeVarInt(serializer, start);
		VarNumberSerializer.writeVarInt(serializer, length);
		ArraySerializer.writeVarIntTArray(serializer, matches, (data, match) -> {
			StringSerializer.writeString(serializer, ProtocolVersionsHelper.LATEST_PC, match.getMatch());
			serializer.writeBoolean(match.hasTooltip());
			if (match.hasTooltip()) {
				StringSerializer.writeString(serializer, ProtocolVersionsHelper.LATEST_PC, match.getTooltip());
			}
		});
		return RecyclableSingletonList.create(serializer);
	}

}
