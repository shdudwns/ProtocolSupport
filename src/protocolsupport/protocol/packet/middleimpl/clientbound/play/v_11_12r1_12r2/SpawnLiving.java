package protocolsupport.protocol.packet.middleimpl.clientbound.play.v_11_12r1_12r2;

import protocolsupport.api.ProtocolVersion;
import protocolsupport.protocol.packet.ClientBoundPacket;
import protocolsupport.protocol.packet.middle.clientbound.play.MiddleSpawnLiving;
import protocolsupport.protocol.packet.middleimpl.ClientBoundPacketData;
import protocolsupport.protocol.serializer.MiscSerializer;
import protocolsupport.protocol.serializer.VarNumberSerializer;
import protocolsupport.protocol.typeremapper.basic.GenericIdRemapper;
import protocolsupport.protocol.typeremapper.legacy.LegacyEntityId;
import protocolsupport.protocol.utils.datawatcher.DataWatcherDeserializer;
import protocolsupport.utils.recyclable.RecyclableCollection;
import protocolsupport.utils.recyclable.RecyclableSingletonList;

public class SpawnLiving extends MiddleSpawnLiving {

	@Override
	public RecyclableCollection<ClientBoundPacketData> toData() {
		ProtocolVersion version = connection.getVersion();
		ClientBoundPacketData serializer = ClientBoundPacketData.create(ClientBoundPacket.PLAY_SPAWN_LIVING_ID);
		VarNumberSerializer.writeVarInt(serializer, entity.getId());
		MiscSerializer.writeUUID(serializer, entity.getUUID());
		VarNumberSerializer.writeVarInt(serializer, LegacyEntityId.getLegacyId(GenericIdRemapper.ENTITY.getTable(version).getRemap(entity.getType())));
		serializer.writeDouble(x);
		serializer.writeDouble(y);
		serializer.writeDouble(z);
		serializer.writeByte(yaw);
		serializer.writeByte(pitch);
		serializer.writeByte(headPitch);
		serializer.writeShort(motX);
		serializer.writeShort(motY);
		serializer.writeShort(motZ);
		DataWatcherDeserializer.encodeData(serializer, version, cache.getAttributesCache().getLocale(), metadata.getRemapped());
		return RecyclableSingletonList.create(serializer);
	}

}
