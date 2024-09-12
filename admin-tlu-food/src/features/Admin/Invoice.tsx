import History from "@/Router/History"
import adminApi from "@/api/adminApi"
import { BillUser, InvoiceRoot } from "@/models"
import { formatCurrencyVND, handlePrice } from "@/utils"
import { Delete, Settings } from "@mui/icons-material"
import { Box, IconButton, Stack, Tab, Tabs, Typography } from "@mui/material"
import dayjs from "dayjs"
import {
  MaterialReactTable,
  type MRT_ColumnDef,
  type MRT_ColumnFiltersState,
  type MRT_PaginationState,
  type MRT_SortingState,
} from "material-react-table"
import { useSnackbar } from "notistack"
import queryString from "query-string"
import { useEffect, useMemo, useRef, useState } from "react"
import { useLocation, useNavigate } from "react-router-dom"

function a11yProps(index: number) {
  return {
    id: `simple-tab-${index}`,
    "aria-controls": `simple-tabpanel-${index}`,
  }
}

interface Data {}

const InvoiceAdmin = () => {
  const location = useLocation() // Get the current location object
  const queryParams = queryString.parse(location.search) // Parse query parameters from the location
  const navigate = useNavigate()
  const [invoice, setInvoice] = useState<BillUser[]>([])
  const [isError, setIsError] = useState(false)
  const [isLoading, setIsLoading] = useState(false)
  const [isRefetching, setIsRefetching] = useState(false)
  const [rowCount, setRowCount] = useState(0)
  //table state
  const [status, setStatus] = useState<string>("ALL")
  const [columnFilters, setColumnFilters] = useState<MRT_ColumnFiltersState>([])
  const [globalFilter, setGlobalFilter] = useState("")
  const [sorting, setSorting] = useState<MRT_SortingState>([])
  const [pagination, setPagination] = useState<MRT_PaginationState>({
    pageIndex: 0,
    pageSize: 10,
  })
  const [isDel, setIsDel] = useState(false)
  const settingRef = useRef<HTMLButtonElement>(null)
  const [tabs, setTabs] = useState(0)
  const handleChange = (event: React.SyntheticEvent, newValue: number) => {
    const tabLabels = ["ALL","PENDING", "PROCESSING", "DELIVERED", "CANCELED"]
    setStatus(tabLabels[newValue])
    setTabs(newValue)
  }
  useEffect(() => {
    const fetchData = async () => {
      if (!invoice.length) {
        setIsLoading(true)
      } else {
        setIsRefetching(true)
      }
      const updatedSearchParams = new URLSearchParams(location.search)
      updatedSearchParams.set("page", `${pagination.pageIndex + 1}`)
      updatedSearchParams.set("size", `${pagination.pageSize}`)
      updatedSearchParams.set("filters", JSON.stringify(columnFilters ?? []))
      updatedSearchParams.set("globalFilter", globalFilter ?? "")
      updatedSearchParams.set("sorting", JSON.stringify(sorting ?? []))
      History.push({ search: updatedSearchParams.toString() })
      try {
        if (status === "ALL") {
          const res = await adminApi.getBill(pagination, null)
          const myInvoice = res.data as InvoiceRoot
          setInvoice(myInvoice.data)
          setRowCount(myInvoice.totalRow)
        } else {
          const res = await adminApi.getBill(pagination, status)
          const myInvoice = res.data as InvoiceRoot
          setInvoice(myInvoice.data)
          setRowCount(myInvoice.totalRow)
        }
      } catch (error) {
        setIsError(true)
        console.error(error)
        return
      }

      setIsError(false)
      setIsLoading(false)
      setIsRefetching(false)
    }
    fetchData()
  }, [
    columnFilters,
    globalFilter,
    isDel,
    pagination.pageIndex,
    pagination.pageSize,
    sorting,
    status,
  ])

  const columns = useMemo<MRT_ColumnDef<BillUser>[]>(
    () => [
      { accessorKey: "id", header: "ID" },
      { accessorKey: "accountId", header: "Người đặt" },
      { header: "Mã đơn" ,Cell:({cell,row})=> `#${dayjs(row.original.createAt).format("DDMMYY")}O${row.original.id}`},
      {
        accessorKey: "shipFee",
        header: "Phí ship",
        Cell: ({ cell }) => formatCurrencyVND(cell.getValue<string>()),
      },
      {
        accessorKey: "totalAmount",
        header: "Tổng đơn hàng",
        Cell: ({ cell }) => formatCurrencyVND(cell.getValue<string>()),
      },
      {
        accessorKey: "finishTime",
        header: "Giờ giao",
      },
      {
        accessorKey: "createAt",
        header: "Tạo lúc",
        Cell: ({ cell }) =>
          dayjs(cell.getValue<string>()).format("HH:mm DD/MM/YYYY"),
      },
    ],
    [],
  )
  return (
    <Box sx={{ height: "100%" }}>
      <Stack
        direction="row"
        sx={{ alignContent: "center", marginLeft: 2 }}
        spacing={2}
      >
        <Box>
          <Typography
            sx={{
              height: "100%",
              textAlign: "center",
              display: "flex",
              alignItems: "center",
            }}
          >
            Trạng thái đơn hàng :
          </Typography>
        </Box>
        <Tabs
          value={tabs}
          onChange={handleChange}
          aria-label="basic tabs example"
        >
          <Tab label="Tất cả" {...a11yProps(0)} />
          <Tab label="Chờ xác nhận" {...a11yProps(1)} />
          <Tab label="Đang vận chuyển" {...a11yProps(2)} />
          <Tab label="Đã hoàn thành" {...a11yProps(3)} />
          <Tab label="Đã hủy" {...a11yProps(4)} />
        </Tabs>
      </Stack>
      <MaterialReactTable
        muiTablePaperProps={{ sx: { height: "100%" } }}
        muiTableContainerProps={{ sx: { height: "calc(100% - 160px)" } }}
        renderTopToolbarCustomActions={({ table }) => (
          <Stack direction="row" alignItems="center">
            <Box sx={{ mr: "10px" }}></Box>
            <Typography sx={{ fontSize: "18px", fontWeight: 500, mr: "10px" }}>
              Bill
            </Typography>
            <IconButton
              ref={settingRef}
              // onClick={handleToggle}
              size="small"
              sx={{ mr: "5px" }}
            >
              <Settings htmlColor="black" fontSize="small" />
            </IconButton>
            {table.getSelectedRowModel().rows.length > 0 && (
              <IconButton
                size="small"
                sx={{ mr: "5px" }}
                onClick={() =>
                  // handleSelectRows(table.getSelectedRowModel().rows)
                  alert("hair ddawng")
                }
              >
                <Delete fontSize="small" htmlColor="black" />
              </IconButton>
            )}
          </Stack>
        )}
        columns={columns}
        data={invoice}
        enableRowSelection
        manualFiltering
        manualPagination
        muiTableBodyRowProps={({ row }) => ({
          onClick: () => {
            navigate(`/admin/update?form=invoice/${row.original.id}`)
          },
          sx: { cursor: "pointer" },
        })}
        manualSorting
        muiToolbarAlertBannerProps={
          isError
            ? {
                color: "error",
                children: "Error loading data",
              }
            : undefined
        }
        positionToolbarAlertBanner="bottom"
        muiLinearProgressProps={({ isTopToolbar }) => ({
          sx: {
            display: isTopToolbar ? "block" : "none", //hide bottom progress bar
          },
        })}
        onColumnFiltersChange={setColumnFilters}
        onGlobalFilterChange={setGlobalFilter}
        onPaginationChange={setPagination}
        onSortingChange={setSorting}
        rowCount={rowCount}
        enableStickyHeader
        state={{
          columnFilters,
          globalFilter,
          isLoading,
          pagination,
          showAlertBanner: isError,
          showProgressBars: isRefetching,
          sorting,
        }}
      />
    </Box>
  )
}

export default InvoiceAdmin
