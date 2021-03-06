package betterquesting.commands.user;

import betterquesting.commands.QuestCommandBase;
import betterquesting.network.PacketSender;
import betterquesting.questing.QuestDatabase;
import betterquesting.questing.QuestLineDatabase;
import betterquesting.storage.LifeDatabase;
import betterquesting.storage.NameCache;
import betterquesting.storage.QuestSettings;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentTranslation;

public class QuestCommandRefresh extends QuestCommandBase
{
	@Override
	public String getCommand()
	{
		return "refresh";
	}
	
	@Override
	public void runCommand(MinecraftServer server, CommandBase command, ICommandSender sender, String[] args)
	{
		if(sender instanceof EntityPlayerMP)
		{
			EntityPlayerMP player = (EntityPlayerMP)sender;
			PacketSender.INSTANCE.sendToPlayer(QuestDatabase.INSTANCE.getSyncPacket(), player);
			PacketSender.INSTANCE.sendToPlayer(QuestLineDatabase.INSTANCE.getSyncPacket(), player);
			PacketSender.INSTANCE.sendToPlayer(LifeDatabase.INSTANCE.getSyncPacket(), player);
			PacketSender.INSTANCE.sendToPlayer(NameCache.INSTANCE.getSyncPacket(), player);
			PacketSender.INSTANCE.sendToPlayer(QuestSettings.INSTANCE.getSyncPacket(), player);
			sender.addChatMessage(new ChatComponentTranslation("betterquesting.cmd.refresh"));
		}
	}
}
