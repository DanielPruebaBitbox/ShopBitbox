import {PriceReduction} from "./priceReduction";
import {Supplier} from "./supplier";
import {setUpLocationSync} from "@angular/router/upgrade";

export class Product {
  // TODO: Add supplier and discounts
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
  public supplier : Supplier[] = [];

  constructor (
    productCode?: number,
    description?: string,
    active?: boolean,
    price?: number,
    creationDate?: Date,
    creator?: number,
    name?: string,
    id?: number,
    priceReduction?: PriceReduction,
    supplier?: Supplier
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
    if(supplier) this.supplier.push(supplier);
  }

}
