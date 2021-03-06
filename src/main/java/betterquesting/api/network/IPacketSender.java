package betterquesting.api.network;

import cpw.mods.fml.common.network.NetworkRegistry.TargetPoint;
import net.minecraft.entity.player.EntityPlayerMP;

public interface IPacketSender
{
    //@Deprecated
	void sendToPlayer(QuestingPacket payload, EntityPlayerMP player);
	
	//void sendToPlayers(QuestingPacket payload, EntityPlayerMP... players);
	void sendToAll(QuestingPacket payload);
	void sendToServer(QuestingPacket payload);
	
	void sendToAround(QuestingPacket payload, TargetPoint point);
	void sendToDimension(QuestingPacket payload, int dimension);
}
