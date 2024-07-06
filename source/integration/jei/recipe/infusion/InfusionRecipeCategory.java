package net.tslat.aoa3.integration.jei.recipe.infusion;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.builder.IRecipeSlotBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.library.util.RecipeUtil;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.tslat.aoa3.advent.AdventOfAscension;
import net.tslat.aoa3.common.registration.block.AoABlocks;
import net.tslat.aoa3.content.recipe.InfusionRecipe;
import net.tslat.aoa3.util.LocaleUtil;

public class InfusionRecipeCategory implements IRecipeCategory<InfusionRecipe> {
	public static final RecipeType<InfusionRecipe> RECIPE_TYPE = RecipeType.create(AdventOfAscension.MOD_ID, "infusion", InfusionRecipe.class);
	public static final ResourceLocation ID = AdventOfAscension.id("infusion");

	private final Component title = LocaleUtil.getLocaleMessage("recipe.aoa3.infusion");
	private final IDrawable background;
	private final IDrawable icon;

	public InfusionRecipeCategory(IGuiHelper guiHelper) {
		ResourceLocation texture = AdventOfAscension.id("textures/gui/containers/infusion_table.png");
		this.background = guiHelper.createDrawable(texture, 10, 10, 156, 66);
		this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(AoABlocks.INFUSION_TABLE.get()));
	}

	@Override
	public RecipeType<InfusionRecipe> getRecipeType() {
		return RECIPE_TYPE;
	}

	@Override
	public Component getTitle() {
		return title;
	}

	@Override
	public IDrawable getBackground() {
		return background;
	}

	@Override
	public IDrawable getIcon() {
		return icon;
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, InfusionRecipe recipe, IFocusGroup focuses) {
		NonNullList<Ingredient> ingredients = recipe.getIngredients();

		builder.addSlot(RecipeIngredientRole.OUTPUT, 128, 25)
				.addItemStack(RecipeUtil.getResultItem(recipe));
		builder.addSlot(RecipeIngredientRole.INPUT, 7, 25)
				.addIngredients(recipe.getInput());

		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				IRecipeSlotBuilder slotBuilder = builder.addSlot(RecipeIngredientRole.INPUT, 35 + x * 18, 7 + y * 18);

				if (x + y * 3 < ingredients.size())
					slotBuilder.addIngredients(ingredients.get(x + y * 3));
			}
		}

		builder.setShapeless();
	}

	/*@Override
	public void draw(InfusionRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
		if (recipe == null)
			return;

		Minecraft mc = Minecraft.getInstance();
		Component message;
		int textColour;
		int shadowColour;
		int width;
		int posX;
		int posY;
		RenderContext renderContext = RenderContext.of(guiGraphics);
		int infusionLevelReq = recipe.getInfusionLevelReq();
		
		if (infusionLevelReq > 1) {
			message = AoASkills.IMBUING.get().getName().append(": " + infusionLevelReq);
			textColour = (ClientPlayerDataManager.get().getSkill(AoASkills.IMBUING.get()).getLevel(true) < infusionLevelReq) ? 0xFFFF6060 : 0xFF80FF20;
			shadowColour = 0xFF000000 | (textColour & 0xFCFCFC) >> 2;
			width = renderContext.textWidth(message);
			posX = 150 - width;
			posY = 10;

			renderContext.renderText(message, posX, posY, textColour, shadowColour, RenderUtil.TextRenderType.DROP_SHADOW, LightTexture.FULL_BRIGHT);
		}

		FloatProvider recipeXp = recipe.getXpProvider();

		if (recipeXp.getMaxValue() > 0) {
			message = LocaleUtil.getLocaleMessage(LocaleUtil.createGenericLocaleKey("gui", "misc.xpAmount"), Component.literal(String.valueOf((recipeXp.getMinValue() == recipeXp.getMaxValue() ? recipeXp.getMaxValue() : recipeXp.getMinValue() + "-" + recipeXp.getMaxValue()))));
			textColour = 0xFF8F8F8F;
			shadowColour = 0xFF000000 | (textColour & 0xFCFCFC) >> 2;
			width = mc.font.width(message);
			posX = 150 - width;
			posY = 50;

			renderContext.renderText(message, posX, posY, textColour, shadowColour, RenderUtil.TextRenderType.DROP_SHADOW, LightTexture.FULL_BRIGHT);
		}
	}*/
}
