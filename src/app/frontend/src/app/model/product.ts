import {PriceReduction} from "./priceReduction";

export class Product {
  // TODO: Add suppliers and discounts
  // You could generate IDs here or give "good" initial values for a newly created product
  public productCode: number = 0;
  public description: string = '';
  public active: boolean = true;
  public price: number = 0;
  public creationDate: Date = new Date();
  public creator: number = 0;
  public name: string = '';
  public id: number = 0;
  public priceReduction: PriceReduction[] = [];

  constructor (
    productCode?: number,
    description?: string,
    active?: boolean,
    price?: number,
    creationDate?: Date,
    creator?: number,
    name?: string,
    id?: number,
    priceReduction?: PriceReduction
  ) {
    this.productCode = productCode || this.productCode;
    this.description = description || this.description;
    this.active = active || this.active;
    this.price = price || this.price;
    this.creationDate = creationDate || this.creationDate;
    this.creator = creator || this.creator;
    this.name = name || this.name;
    this.id = id || this.id;
    if(priceReduction) this.priceReduction.push(priceReduction);
  }

}
