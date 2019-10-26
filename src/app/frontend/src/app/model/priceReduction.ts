export class PriceReduction {
  public reductionPrice: number = 0;
  public startDate: Date = new Date()
  public endDate: Date = new Date()
  public id: number = 0;

  constructor(
    reductionPrice?: number,
    startDate?: Date,
    endDate?: Date,
    id?: number
  ) {
    this.reductionPrice = reductionPrice || this.reductionPrice;
    this.startDate = startDate || this.startDate;
    this.startDate = endDate || this.endDate;
    this.id = id || this.id;
  }
}
