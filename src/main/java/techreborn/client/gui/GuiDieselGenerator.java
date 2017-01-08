package techreborn.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;

import reborncore.common.powerSystem.PowerSystem;

import techreborn.client.container.builder.ContainerBuilder;
import techreborn.tiles.generator.TileDieselGenerator;

public class GuiDieselGenerator extends GuiContainer {

	private static final ResourceLocation texture = new ResourceLocation("techreborn",
			"textures/gui/diesel_generator.png");

	TileDieselGenerator tile;

	public GuiDieselGenerator(final EntityPlayer player, final TileDieselGenerator tile) {
		super(new ContainerBuilder("fluidgenerator").player(player.inventory).inventory(8, 84).hotbar(8, 142)
				.addInventory().tile(tile).slot(0, 80, 17).outputSlot(1, 80, 53).fakeSlot(2, 59, 42).syncEnergyValue()
				.addInventory().create());
		this.xSize = 176;
		this.ySize = 167;
		this.tile = tile;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(final float p_146976_1_, final int p_146976_2_, final int p_146976_3_) {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(GuiDieselGenerator.texture);
		final int k = (this.width - this.xSize) / 2;
		final int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(final int p_146979_1_, final int p_146979_2_) {
		final String name = I18n.translateToLocal("tile.techreborn.dieselgenerator.name");
		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6,
				4210752);
		this.fontRendererObj.drawString(I18n.translateToLocalFormatted("container.inventory", new Object[0]), 8,
				this.ySize - 96 + 2, 4210752);
		this.fontRendererObj.drawString("Liquid Amount", 10, 20, 16448255);
		this.fontRendererObj.drawString(this.tile.tank.getFluidAmount() + "", 10, 30, 16448255);

		this.fontRendererObj.drawString("Power Amount", 10, 40, 16448255);
		this.fontRendererObj.drawString(PowerSystem.getLocaliszedPower(this.tile.getEnergy()) + "", 10, 50,
				16448255);
	}
}
