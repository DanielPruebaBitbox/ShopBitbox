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

  constructor (
    productCode?: number,
    description?: string,
    active?: boolean,
    price?: number,
    creationDate?: Date,
    creator?: number,
    name?: string,
    id?: number
  ) {
    this.productCode = productCode || this.productCode;
    this.description = description || this.description;
    this.active = active || this.active;
    this.price = price || this.price;
    this.creationDate = creationDate || this.creationDate;
    this.creator = creator || this.creator;
    this.name = name || this.name;
    this.id = id || this.id;
  }

 /* setProductCode(productCode: number): void {
    this.productCode = productCode;
  };
  getProductCode(): number {
    return this.productCode;
  };
  setDescription(description: string): void {
    this.description = description;
  };
  getDescription(): string {
    return this.description;
  };
  setActive(active: boolean): void {
    this.active = active;
  };
  getActive(): boolean {
    return this.active;
  };
  setPrice(price: number): void {
    this.price = price;
  };
  getPrice(): number {
    return this.price;
  };
  // Creation date should be an automatically generated value right?
  setCreationDate(creationDate: Date): void {
    this.creationDate = creationDate;
  };
  getCreationDate(): Date {
    return this.creationDate;
  };
  setCreator(creatorId: number): void {
    this.creator = creatorId;
  };
  getCreator(): number {
    return this.creator;
  };
  setName(name: string): void {
    this.name = name;
  };
  getName(): string {
    return this.name;
  };
  setId(id: number): void {
    this.id = id;
  };
  getId() : number {
    return this.id;
  };*/
};
