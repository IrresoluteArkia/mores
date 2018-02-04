package com.irar.mores.items;

import java.awt.Color;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.irar.mores.enchanting.EnchantmentSet;
import com.irar.mores.handlers.CreativeTabHandler;
import com.irar.mores.handlers.ItemHandler;
import com.irar.mores.name.AlloyName;

import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scala.Char;

public class AlloyBow extends ItemBow implements IItemColor{

	public AlloyBow(String name) {
		super();
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
        this.addPropertyOverride(new ResourceLocation("pull"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                if (entityIn == null)
                {
                    return 0.0F;
                }
                else
                {
                    return entityIn.getActiveItemStack().getItem() != ItemHandler.AlloyBow ? 0.0F : (float)(stack.getMaxItemUseDuration() - entityIn.getItemInUseCount()) / 20.0F;
                }
            }
        });
	}

	@Override
	public int getColorFromItemstack(ItemStack stack, int tintIndex) {
        return tintIndex > 0 ? -1 : getColor(stack);
	}

	public static int getColor(ItemStack stack) {
		if(stack.hasTagCompound() && stack.getTagCompound().hasKey("INGOT_DATA")) {
			Random r = new Random(stack.getTagCompound().getInteger("INGOT_DATA") + toInt("color"));
			Color c = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
			return c.getRGB();
		}
		return 0;
	}
	
	private static int toInt(String s) {
		int ret = 0;
		for(char c : s.toCharArray()) {
			ret += Char.char2int(c);
		}
		return ret;
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		if(stack.hasTagCompound() && stack.getTagCompound().hasKey("INGOT_DATA")) {
			Random r = new Random(stack.getTagCompound().getInteger("INGOT_DATA") + toInt("name"));
			String name = AlloyName.getRandomName(r) + " Bow";
			return name;
		}
		return "Alloy Bow";
	}

	public static ItemStack withValue(int value) {
		ItemStack stack = new ItemStack(ItemHandler.AlloyBow);
		NBTTagCompound tag = stack.serializeNBT();
		tag.setInteger("INGOT_DATA", value);
		stack.setTagCompound(tag);
		enchant(stack);
		return stack;
	}

    private static void enchant(ItemStack stack) {
		EnchantmentSet enchants = new EnchantmentSet(stack);
		enchants.enchant(stack);
	}
    
    @Override
    public int getItemEnchantability()
    {
        return 10;
    }

	@Override
	public int getMaxDamage(ItemStack stack) {
		if(stack.hasTagCompound() && stack.getTagCompound().hasKey("INGOT_DATA")) {
			int num = stack.getTagCompound().getInteger("INGOT_DATA");
			Random r = new Random(num + toInt("damage"));
			return Math.max(10, (num * 10) + r.nextInt(200) - 100);
		}
		return 1;
	}

	@Override
    public int getMaxItemUseDuration(ItemStack stack)
    {
		if(stack.hasTagCompound() && stack.getTagCompound().hasKey("INGOT_DATA")) {
			int num = stack.getTagCompound().getInteger("INGOT_DATA");
			Random r = new Random(num + toInt("duration"));
			return (int) (72000 / Math.pow(((1.0F * Math.log(num)) * (r.nextFloat())), 2));
		}
        return 72000;
    }
	
    public static float getArrowVelocity(int charge, ItemStack stack)
    {
        float f = (float)charge / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;

		if(stack.hasTagCompound() && stack.getTagCompound().hasKey("INGOT_DATA")) {
			int num = stack.getTagCompound().getInteger("INGOT_DATA");
			Random r = new Random(num + toInt("efficiency"));
			return (float) ((0.1F * Math.log(num)) * f);
		}
		return f;
    }
    
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft)
    {
        if (entityLiving instanceof EntityPlayer)
        {
            EntityPlayer entityplayer = (EntityPlayer)entityLiving;
            boolean flag = entityplayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
            ItemStack itemstack = this.findAmmo(entityplayer);

            int i = this.getMaxItemUseDuration(stack) - timeLeft;
            i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, entityplayer, i, !itemstack.isEmpty() || flag);
            if (i < 0) return;

            if (!itemstack.isEmpty() || flag)
            {
                if (itemstack.isEmpty())
                {
                    itemstack = new ItemStack(Items.ARROW);
                }

                float f = getArrowVelocity(i, stack);

                if ((double)f >= 0.1D)
                {
                    boolean flag1 = entityplayer.capabilities.isCreativeMode || (itemstack.getItem() instanceof ItemArrow && ((ItemArrow) itemstack.getItem()).isInfinite(itemstack, stack, entityplayer));

                    if (!worldIn.isRemote)
                    {
                        ItemArrow itemarrow = (ItemArrow)(itemstack.getItem() instanceof ItemArrow ? itemstack.getItem() : Items.ARROW);
                        EntityArrow entityarrow = itemarrow.createArrow(worldIn, itemstack, entityplayer);
                        entityarrow.setAim(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw, 0.0F, f * 3.0F, 0.0F);

                        if (f == 1.0F)
                        {
                            entityarrow.setIsCritical(true);
                        }

                        int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);

                        if (j > 0)
                        {
                            entityarrow.setDamage(entityarrow.getDamage() + (double)j * 0.5D + 0.5D);
                        }

                        int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);

                        if (k > 0)
                        {
                            entityarrow.setKnockbackStrength(k);
                        }

                        if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0)
                        {
                            entityarrow.setFire(100);
                        }

                        stack.damageItem(1, entityplayer);

                        if (flag1 || entityplayer.capabilities.isCreativeMode && (itemstack.getItem() == Items.SPECTRAL_ARROW || itemstack.getItem() == Items.TIPPED_ARROW))
                        {
                            entityarrow.pickupStatus = EntityArrow.PickupStatus.CREATIVE_ONLY;
                        }

                        worldIn.spawnEntity(entityarrow);
                    }

                    worldIn.playSound((EntityPlayer)null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

                    if (!flag1 && !entityplayer.capabilities.isCreativeMode)
                    {
                        itemstack.shrink(1);

                        if (itemstack.isEmpty())
                        {
                            entityplayer.inventory.deleteStack(itemstack);
                        }
                    }

                    entityplayer.addStat(StatList.getObjectUseStats(this));
                }
            }
        }
    }
    
    private ItemStack findAmmo(EntityPlayer player)
    {
        if (this.isArrow(player.getHeldItem(EnumHand.OFF_HAND)))
        {
            return player.getHeldItem(EnumHand.OFF_HAND);
        }
        else if (this.isArrow(player.getHeldItem(EnumHand.MAIN_HAND)))
        {
            return player.getHeldItem(EnumHand.MAIN_HAND);
        }
        else
        {
            for (int i = 0; i < player.inventory.getSizeInventory(); ++i)
            {
                ItemStack itemstack = player.inventory.getStackInSlot(i);

                if (this.isArrow(itemstack))
                {
                    return itemstack;
                }
            }

            return ItemStack.EMPTY;
        }
    }


}
