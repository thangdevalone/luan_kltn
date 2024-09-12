import {useAppDispatch, useAppSelector} from "@/app/hooks"
import {InputField, PasswordField} from "@/components/FormControls"
import {RegisterForm} from "@/models"
import {yupResolver} from "@hookform/resolvers/yup"
import "./styles.css"
import {LockOutlined} from "@mui/icons-material"
import {
  Avatar,
  Box,
  Button,
  Checkbox,
  Container,
  FormControlLabel,
  Grid,
  LinearProgress,
  Typography,
} from "@mui/material"
import {useSnackbar} from "notistack"
import {ChangeEvent, useEffect, useRef, useState} from "react"
import {FormProvider, SubmitHandler, useForm} from "react-hook-form"
import {Link} from "react-router-dom"
import * as yup from "yup"
import {authActions} from "../AuthSlice"

export interface RegisterPageProps {
}

const options = {
  apiKey: "public_W142iH1DTtrDZfdVtpSbfny5htLw",
  maxFileCount: 1,
}

function Copyright(props: any) {
  return (
    <Typography
      variant="body2"
      color="text.secondary"
      align="center"
      {...props}
    >
      {"Copyright © "}
      <Link color="inherit" to="#">
        Iot soup
      </Link>{" "}
      {new Date().getFullYear()}
      {"."}
    </Typography>
  )
}

export function RegisterPage(props: RegisterPageProps) {
  const dispatch = useAppDispatch()
  const registering = useAppSelector((state) => state.auth.registering)
  const actionAuth = useAppSelector((state) => state.auth.actionAuth)
  const [msv, setMsv] = useState<string>("")
  const {enqueueSnackbar} = useSnackbar()
  const [loading, setLoading] = useState(false)
  const fileInputRef = useRef<HTMLInputElement | null>(null)
  const [file, setFile] = useState<File | null>(null)
  const phoneRegExp =
    /^((\\+[1-9]{1,4}[ \\-]*)|(\\([0-9]{2,3}\\)[ \\-]*)|([0-9]{2,4})[ \\-]*)*?[0-9]{3,4}?[ \\-]*[0-9]{3,4}?$/

  const [checked, setChecked] = useState(false)
  const handleChange = (event: ChangeEvent<HTMLInputElement>) => {
    setChecked(event.target.checked)
  }
  const schema = yup.object().shape({
    name: yup
      .string()
      .required("Hãy nhập tên đầy đủ của bạn")
      .test(
        "Họ và tên nên gồm 2 từ trở lên",
        "Họ và tên gồm 2 từ trở lên chỉ bao gồm chữ cái",
        (value) => {
          const words = value.trim().split(" ")
          return (
            words.length >= 2 &&
            words.every(
              (word) => !/\d[@#$%^&*()_+{}\[\]:;<>,.?~\\|/]/.test(word),
            )
          )
        },
      ),
    username: yup
      .string()
      .required("Nhập tên đăng nhập"),
    phoneNumber: yup
      .string()
      .required("Điền số điện thoại")
      .matches(phoneRegExp, "Số điện thoại không hợp lệ")
      .min(9, "Quá ngắn")
      .max(11, "Quá dài"),
    password: yup
      .string()
      .required("Nhập mật khẩu")
      .min(8, "Mật khẩu phải dài hơn 8 kí tự")
      .max(32, "Mật khẩu quá dài")
      .matches(/[A-Z]+/, "Mật khẩu cần ít nhất 1 kí tự in hoa")
      .matches(/[a-z]+/, "Mật khẩu cần ít nhất 1 kí tự in thường"),
    rePassword: yup
      .string()
      .required("Nhập lại mật khẩu")
      .oneOf([yup.ref("password")], "Mật khẩu không khớp"),
  })
  const [selectedImage, setSelectedImage] = useState<string | null>(null)
  const form = useForm<RegisterForm>({
    defaultValues: {username: msv},
    resolver: yupResolver(schema),
  })
  const handleRegister: SubmitHandler<RegisterForm> = (data) => {
    const rsData: RegisterForm = {
      ...data,
      name: data.name.replace(/\s+/g, " ").trim(),
    }
    dispatch(authActions.register(rsData))
  }
  useEffect(() => {
    if (actionAuth == "Failed") {
      enqueueSnackbar("Tên đăng nhập đã được sử dụng", {
        variant: "error",
      })
    }
  }, [actionAuth])
  return (
    <div className="dot-backg min-h-[100vh] w-screen">
      {registering ||
        (loading && (
          <LinearProgress
            sx={{position: "fixed", top: "0px", left: "0px", width: "100%"}}
          />
        ))}
      <Container component="main" maxWidth={"xs"}>
        <Box
          sx={{
            marginTop: 8,
            display: "flex",
            flexDirection: "column",
            alignItems: "center",
          }}
        >
          <Avatar sx={{m: 1, bgcolor: "secondary.main"}}>
            <LockOutlined/>
          </Avatar>
          <Typography component="h1" variant="h5">
            Đăng ký
          </Typography>
          <FormProvider {...form}>
            <Box
              component="form"
              onSubmit={form.handleSubmit(handleRegister)}
              sx={{mt: 2}}
            >
              <InputField name="name" label="Họ và tên"/>
              <Grid container spacing={2}>
                <Grid item xs={6}>
                  <InputField
                    name="username"
                    disabled={Boolean(msv && msv?.length !== 0)}
                    label="Tên đăng nhập"
                  />
                </Grid>
                <Grid item xs={6}>
                  <InputField name="phoneNumber" label="Số điện thoại"/>
                </Grid>
              </Grid>

              <PasswordField name="password" label="Mật khẩu"/>
              <PasswordField name="rePassword" label="Nhập lại mật khẩu"/>
              <FormControlLabel
                control={
                  <Checkbox
                    checked={checked}
                    onChange={handleChange}
                    color="primary"
                  />
                }
                label={
                  <span>
                        Tôi đã đọc và đồng ý với{" "}
                    <a
                      target="_blank"
                      href="https://docs.google.com/document/d/1AzgImd9LS0Vs1wTFTgnxc51V4ETVlph7FeryDaOox_M/edit?usp=sharing"
                      style={{
                        color: "blue",
                        textDecoration: "underline",
                        cursor: "pointer",
                      }}
                    >
                          Điều khoản và Chính sách bảo mật
                        </a>
                      </span>
                }
              />
              <Button
                type="submit"
                disabled={registering || !checked}
                fullWidth
                variant="contained"
                sx={{mt: 3, mb: 2}}
              >
                Đăng ký
              </Button>

              <Grid container>
                <Grid item xs></Grid>
                <Grid item>
                  <Link
                    to="/login"
                    style={{
                      color: "blue",
                      textDecoration: "underline",
                      cursor: "pointer",
                    }}
                  >
                    {"Bạn đã có tài khoản? Đăng nhập"}
                  </Link>
                </Grid>
              </Grid>
            </Box>
          </FormProvider>
        </Box>
        <Copyright sx={{mt: 6, mb: 4}}/>
      </Container>
    </div>
  )
}
