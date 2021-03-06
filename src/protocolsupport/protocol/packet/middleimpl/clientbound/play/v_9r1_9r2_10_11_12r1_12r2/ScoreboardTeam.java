package protocolsupport.protocol.packet.middleimpl.clientbound.play.v_9r1_9r2_10_11_12r1_12r2;

import protocolsupport.api.ProtocolVersion;
import protocolsupport.protocol.packet.ClientBoundPacket;
import protocolsupport.protocol.packet.middle.clientbound.play.MiddleScoreboardTeam;
import protocolsupport.protocol.packet.middleimpl.ClientBoundPacketData;
import protocolsupport.protocol.serializer.ArraySerializer;
import protocolsupport.protocol.serializer.StringSerializer;
import protocolsupport.utils.Utils;
import protocolsupport.utils.recyclable.RecyclableCollection;
import protocolsupport.utils.recyclable.RecyclableSingletonList;

public class ScoreboardTeam extends MiddleScoreboardTeam {

	@Override
	public RecyclableCollection<ClientBoundPacketData> toData() {
		ProtocolVersion version = connection.getVersion();
		ClientBoundPacketData serializer = ClientBoundPacketData.create(ClientBoundPacket.PLAY_SCOREBOARD_TEAM_ID);
		StringSerializer.writeString(serializer, version, name);
		serializer.writeByte(mode);
		if ((mode == 0) || (mode == 2)) {
			String locale = cache.getAttributesCache().getLocale();
			StringSerializer.writeString(serializer, version, Utils.clampString(displayName.toLegacyText(locale), 32));
			StringSerializer.writeString(serializer, version, Utils.clampString(prefix.toLegacyText(locale), 16));
			StringSerializer.writeString(serializer, version, Utils.clampString(suffix.toLegacyText(locale), 16));
			serializer.writeByte(friendlyFire);
			StringSerializer.writeString(serializer, version, nameTagVisibility);
			StringSerializer.writeString(serializer, version, collisionRule);
			serializer.writeByte(color <= 15 ? color : -1);
		}
		if ((mode == 0) || (mode == 3) || (mode == 4)) {
			ArraySerializer.writeVarIntStringArray(serializer, version, players);
		}
		return RecyclableSingletonList.create(serializer);
	}

}
