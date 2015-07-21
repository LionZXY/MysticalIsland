
package com.lionzxy.mysticalisland.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class FlintGun extends ModelBase
{
  //fields
  public ModelRenderer Shape1;
  public ModelRenderer Shape2;
  public ModelRenderer Shape4;
  public ModelRenderer Shape5;
  public ModelRenderer Shape3;
  public ModelRenderer Shape6;
  public ModelRenderer Shape7;
  public ModelRenderer Shape8;
  public ModelRenderer Shape9;
  public ModelRenderer Shape10;
  public ModelRenderer Shape11;
  public ModelRenderer Shape12;
  public ModelRenderer Shape13;
  public ModelRenderer Shape14;
  public ModelRenderer Shape15;
  public ModelRenderer Shape16;
  
  public FlintGun()
  {
    textureWidth = 50;
    textureHeight = 40;
    
      Shape1 = new ModelRenderer(this, 0, 33);
      Shape1.addBox(0F, 0F, 0F, 20, 2, 1);
      Shape1.setRotationPoint(0F, 0F, 0F);
      Shape1.setTextureSize(50, 40);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 0, 38);
      Shape2.addBox(0F, 0F, 0F, 3, 1, 1);
      Shape2.setRotationPoint(20F, 0F, 0F);
      Shape2.setTextureSize(50, 40);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 0, 29);
      Shape4.addBox(0F, 0F, 0F, 20, 1, 1);
      Shape4.setRotationPoint(0F, 0.5F, 0.5F);
      Shape4.setTextureSize(50, 40);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 0, 29);
      Shape5.addBox(0F, 0F, 0F, 20, 1, 1);
      Shape5.setRotationPoint(0F, 0.5F, -0.5F);
      Shape5.setTextureSize(50, 40);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 0, 29);
      Shape3.addBox(0F, 0F, 0F, 20, 1, 1);
      Shape3.setRotationPoint(0F, 1F, -0.4F);
      Shape3.setTextureSize(50, 40);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 0, 29);
      Shape3.addBox(0F, 0F, 0F, 20, 1, 1);
      Shape3.setRotationPoint(0F, 1F, 0.4F);
      Shape3.setTextureSize(50, 40);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 0, 38);
      Shape6.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape6.setRotationPoint(21F, -0.5F, 0F);
      Shape6.setTextureSize(50, 40);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, 0F);
      Shape7 = new ModelRenderer(this, 0, 37);
      Shape7.addBox(0F, 0F, 0F, 2, 1, 1);
      Shape7.setRotationPoint(4F, -0.5333334F, 0F);
      Shape7.setTextureSize(50, 40);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, 0.2268928F);
      Shape8 = new ModelRenderer(this, 0, 29);
      Shape8.addBox(-13F, 0F, 0F, 11, 2, 1);
      Shape8.setRotationPoint(2F, -0.3F, 0F);
      Shape8.setTextureSize(50, 40);
      Shape8.mirror = true;
      setRotation(Shape8, 0F, 0F, -0.2268928F);
      Shape9 = new ModelRenderer(this, 0, 29);
      Shape9.addBox(-7F, 0F, 0F, 7, 2, 1);
      Shape9.setRotationPoint(-3.6F, 1F, 0F);
      Shape9.setTextureSize(50, 40);
      Shape9.mirror = true;
      setRotation(Shape9, 0F, 0F, 0.0261799F);
      Shape10 = new ModelRenderer(this, 0, 37);
      Shape10.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape10.setRotationPoint(2F, 2F, 0F);
      Shape10.setTextureSize(50, 40);
      Shape10.mirror = true;
      setRotation(Shape10, 0F, 0F, 0F);
      Shape11 = new ModelRenderer(this, 0, 37);
      Shape11.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape11.setRotationPoint(1F, 2.7F, 0F);
      Shape11.setTextureSize(50, 40);
      Shape11.mirror = true;
      setRotation(Shape11, 0F, 0F, 0F);
      Shape12 = new ModelRenderer(this, 0, 37);
      Shape12.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape12.setRotationPoint(0F, 2F, 0F);
      Shape12.setTextureSize(50, 40);
      Shape12.mirror = true;
      setRotation(Shape12, 0F, 0F, 0F);
      Shape13 = new ModelRenderer(this, 0, 37);
      Shape13.addBox(0F, 0F, 0F, 1, 1, 0);
      Shape13.setRotationPoint(0.4F, 2F, 0.4F);
      Shape13.setTextureSize(50, 40);
      Shape13.mirror = true;
      setRotation(Shape13, 0F, 0F, -0.2443461F);
      Shape14 = new ModelRenderer(this, 0, 37);
      Shape14.addBox(0F, 0F, 0F, 1, 2, 1);
      Shape14.setRotationPoint(1F, -1F, -1F);
      Shape14.setTextureSize(50, 40);
      Shape14.mirror = true;
      setRotation(Shape14, 0F, 0F, 0.296706F);
      Shape15 = new ModelRenderer(this, 0, 26);
      Shape15.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape15.setRotationPoint(1.8F, -0.9F, -1F);
      Shape15.setTextureSize(50, 40);
      Shape15.mirror = true;
      setRotation(Shape15, 0F, 0F, -0.7853982F);
      Shape16 = new ModelRenderer(this, 0, 37);
      Shape16.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape16.setRotationPoint(1F, -1F, -1F);
      Shape16.setTextureSize(50, 40);
      Shape16.mirror = true;
      setRotation(Shape16, 0F, 0F, -0.2617994F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5,entity);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape4.render(f5);
    Shape5.render(f5);
    Shape3.render(f5);
    Shape3.render(f5);
    Shape6.render(f5);
    Shape7.render(f5);
    Shape8.render(f5);
    Shape9.render(f5);
    Shape10.render(f5);
    Shape11.render(f5);
    Shape12.render(f5);
    Shape13.render(f5);
    Shape14.render(f5);
    Shape15.render(f5);
    Shape16.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
