package techreborn.blockentity.machine.tier0.block.blockplacer;

import net.minecraft.text.Text;
import reborncore.common.util.Color;
import techreborn.blockentity.machine.tier0.block.ProcessingStatus;

/**
 * An enumeration of different statuses the Block Placer can have
 *
 * Includes {@code TranslatableText} describing the status along with a text color
 *
 * @author SimonFlapse
 */
enum BlockPlacerStatus implements ProcessingStatus {
	IDLE(Text.translatable("gui.techreborn.block_placer.idle"), Color.BLUE),
	IDLE_PAUSED(Text.translatable("gui.techreborn.block.idle_redstone"), Color.BLUE),
	NO_ENERGY(Text.translatable("gui.techreborn.block.no_energy"), Color.RED),
	INTERRUPTED(Text.translatable("gui.techreborn.block.interrupted"), Color.RED),
	OUTPUT_BLOCKED(Text.translatable("gui.techreborn.block.output_blocked"), Color.RED),
	PROCESSING(Text.translatable("gui.techreborn.block_placer.processing"), Color.DARK_GREEN);

	private final Text text;
	private final int color;

	BlockPlacerStatus(Text text, Color color) {
		this.text = text;
		this.color = color.getColor();
	}

	@Override
	public Text getText() {
		return text;
	}

	@Override
	public Text getProgressText(int progress) {
		progress = Math.max(progress, 0);

		if (this == PROCESSING) {
			return Text.translatable("gui.techreborn.block.progress.active", Text.literal("" + progress + "%"));
		} else if (this == IDLE || this == INTERRUPTED) {
			return Text.translatable("gui.techreborn.block.progress.stopped");
		} else {
			return Text.translatable("gui.techreborn.block.progress.paused", Text.literal("" + progress + "%"));
		}
	}

	@Override
	public int getColor() {
		return color;
	}

	@Override
	public int getStatusCode() {
		return this.ordinal();
	}
}
