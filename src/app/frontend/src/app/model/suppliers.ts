export class Suppliers {
  public country : string = "";
  public name : string = "";
  public id: number = 0;

  constructor(
    name?: string,
    country?: string,
    id?: number
  ) {
    this.name = name || this.name;
    this.country = country || this.country;
    this.id = id || this.id;
  }
}
