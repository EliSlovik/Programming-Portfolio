class Pyramid:
  len = 0.0
  hei = 0.0
  def __init__(self):
    self.len = 0.0
    self.hei = 0.0
  def volume(self):
   return self.len * self.len * self.hei * (1/3)
  def surfaceArea(self):
    sidea = (1/2) * self.len
    sideb = self.hei
    slant = (sidea**2 + sideb**2)**(1/2)
    perimiter = self.len * 4 
    basearea = self.len * self.len
    return  basearea + 0.5 * perimiter*slant
    #area of base + 1/2 perimiter * slant
