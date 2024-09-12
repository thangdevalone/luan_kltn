import { FoodResponseBill } from "@/models"
export interface FoodBill {
  nameRes: string
  address:string
  data: Food[]
}

export interface Food {
  foodId: number
  nameFood: string
  priceFood: number
  quantity: number
  nameRes: string
  resId: number
  itemList: any
  address?: string
}
export function handleFoodBill(data: FoodResponseBill[]): FoodBill[] {
  const rs: FoodBill[] = []

  for (const item of data) {
    const existingBill = rs.find((bill) => bill.nameRes === item.nameRes)

    if (existingBill) {
      existingBill.data.push(item)
    } else {
      const newBill: FoodBill = {
        nameRes: item.nameRes || "",
        address:item.address || "",
        data: [item],
      }
      rs.push(newBill)
    }
  }

  return rs
}
