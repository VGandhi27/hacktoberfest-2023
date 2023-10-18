package main

import (
	"fmt"
	"os"
	"os/exec"
)

func main() {
	var option int
	var akses string

	fmt.Println("=============================")
	fmt.Println("=== Aplikasi Bangun Datar ===")
	fmt.Println("=============================")

	fmt.Println("== 1. Persegi              ==")
	fmt.Println("== 2. Persegi Panjang      ==")
	fmt.Println("== 3. Segitiga             ==")
	fmt.Println("== 4. Kotak                ==")
	fmt.Println("== 5. Info                 ==")
	fmt.Println("=============================")
	fmt.Print("Masukan Pilihan : ")
	fmt.Scanln(&option)

	switch option {
	case 1:
		persegi()
	persegi:
		fmt.Println("Apakah anda ingin keluar (y/n) : ")
		fmt.Scanln(&akses)

		if akses == "y" || akses == "Y" {
			fmt.Println()
			var output2, _ = exec.Command("clear").Output()
			fmt.Print(string(output2))
			main()
		} else if akses == "n" || akses == "N" {
			var output1, _ = exec.Command("clear").Output()
			fmt.Print(string(output1))
			persegi()
			goto persegi
		} else {
			os.Exit(2)
		}
	case 2:
		persegiPanjang()
	persegiPanjang:
		fmt.Println("Apakah anda ingin keluar (y/n) : ")
		fmt.Scanln(&akses)

		if akses == "y" || akses == "Y" {
			fmt.Println()
			var output2, _ = exec.Command("clear").Output()
			fmt.Print(string(output2))
			main()
		} else if akses == "n" || akses == "N" {
			var output1, _ = exec.Command("clear").Output()
			fmt.Print(string(output1))
			persegiPanjang()
			goto persegiPanjang
		} else {
			os.Exit(2)
		}
	case 3:
		segitiga()
	segitiga:
		fmt.Println("Apakah anda ingin keluar (y/n) : ")
		fmt.Scanln(&akses)

		if akses == "y" || akses == "Y" {
			fmt.Println()
			var output2, _ = exec.Command("clear").Output()
			fmt.Print(string(output2))
			main()
		} else if akses == "n" || akses == "N" {
			var output1, _ = exec.Command("clear").Output()
			fmt.Print(string(output1))
			segitiga()
			goto segitiga
		} else {
			os.Exit(2)
		}
	case 4:
		kotak()
	kotak:
		fmt.Println("Apakah anda ingin keluar (y/n) : ")
		fmt.Scanln(&akses)

		if akses == "y" || akses == "Y" {
			fmt.Println()
			var output2, _ = exec.Command("clear").Output()
			fmt.Print(string(output2))
			main()
		} else if akses == "n" || akses == "N" {
			var output1, _ = exec.Command("clear").Output()
			fmt.Print(string(output1))
			kotak()
			goto kotak
		} else {
			os.Exit(2)
		}
	case 5:
		info()
	default:
		os.Exit(1)
	}
}

func persegi() {
	var i, j, sisi int

	fmt.Print("Masukan Nilai [Persegi] : ")
	fmt.Scanln(&sisi)

	for i = 0; i < sisi; i++ {
		for j = 0; j < sisi; j++ {
			fmt.Print("= ")
		}
		fmt.Println()
	}
}

func persegiPanjang() {
	var i, j, sisi, sisi2 int

	fmt.Print("Masukan Panjang Sisi [Persegi Panjang] : ")
	fmt.Scanln(&sisi)
	fmt.Print("Masukan Lebar Sisi [Persegi Panjang] : ")
	fmt.Scanln(&sisi2)

	for i = 0; i < sisi2; i++ {
		for j = 0; j < sisi; j++ {
			fmt.Print("= ")
		}
		fmt.Println()
	}
}

func segitiga() {
	//Mendeklarasikan Variable
	var i, j, k, nilai int

	//Menginput Nilai
	fmt.Print("Masukan Nilai [Segitiga] : ")
	fmt.Scanln(&nilai)

	//Perulangan dengan if
	for i = 1; i <= nilai; i++ {
		for j = nilai; j > i; j-- {
			fmt.Print(" ")
		}
		for k = 1; k <= i; k++ {
			fmt.Print("= ")
		}
		fmt.Println()
	}
	fmt.Println()
}

func kotak() {
	var i, j, nilai int

	fmt.Print("Masukan Nilai [Kotak] : ")
	fmt.Scanln(&nilai)

	for i = 0; i < nilai; i++ {
		for j = 0; j < nilai; j++ {
			if i == 0 || i == nilai-1 || j == 0 || j == nilai-1 {
				fmt.Print("* ")
			} else {
				fmt.Print("  ")
			}
		}
		fmt.Println()
	}
}

func info() {
	var akses string

	fmt.Print("Apakah anda ingin masuk ke dalam info (y/n) : ")
	fmt.Scanln(&akses)

	if akses == "y" || akses == "Y" {
		fmt.Println()
		var output2, _ = exec.Command("clear").Output()
		fmt.Print(string(output2))
		main()
	} else if akses == "n" || akses == "N" {
		var output1, _ = exec.Command("clear").Output()
		fmt.Print(string(output1))
	}
}
