#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <conio.h>
#include <time.h>
#include <windows.h>
void menu();
void tambah_mhs();
void tampil_mhs();
void edit_mhs();
void hapus_mhs();
void cari_mhs();
void close();
void header();
void statistik_nilai();
void tampil_sort();
struct DATA {
	char nama[30];
	int umur,id;
	char jk[30];
	float nilai[5];
	int total;
	
}tambah,cek,hapus,sort[100],temp;

char index[2];
struct date{
	int tgl;
	int bln;
	int thn;
};
int main()
{
	system("cls");
		printf("Now Loading");
		Sleep(500);
		printf(". ");
		Sleep(500);
		printf(". ");
		Sleep(500);
		printf(". ");
		Sleep(500);
		printf(". ");
		Sleep(500);
		printf(". ");
	menu();
	return 0;
}
void menu(){
	int pilih;
	menu:
		system("cls");
		header();
		printf("MAIN MENU ::");
		printf("\n[1]. Tambah Mahasiswa Dan Nilai Mahasiswa");
		printf("\n[2]. Tampil Data Mahasiswa");
		printf("\n[3]. Cari Data Lengkap Mahasiswa");
		printf("\n[4]. Hapus Data Mahasiswa");
		printf("\n[5]. Edit Data Mahasiswa");
		printf("\n[6]. Statistik Nilai");
		printf("\n[7]. Menampilkan Total Nilai ASCENDING Dan DESCENDING");	
		printf("\n[8]. Keluar");
		printf("\n\nInput Pilihan Nomor Menu : ");
		scanf("%d", &pilih);
		switch(pilih){
			case 1:tambah_mhs();
				break;
			case 2:tampil_mhs();
				break;
			case 3: cari_mhs();
				break;	
			case 4:hapus_mhs();
				break;
			case 5:edit_mhs();
				break;
			case 6:statistik_nilai();
				break;
			case 7:tampil_sort();
				break;
			case 8:close();
				break;
			default:printf("\nMohon Maaf Pilihan Anda Salah !");
				getche();
				goto menu;
		}
}
void tambah_mhs(){
	FILE *ptr,*ptr1;
	int count=0;
	
	ptr =fopen("mahasiswa.txt","a");
		system("cls");
		ptr1 =fopen("mahasiswa.txt","r");
		while (fscanf (ptr1,"%d;%[^;];%[^;];%d;%f;%f;%f;%f;%f\n",&tambah.id,tambah.nama,tambah.jk,&tambah.umur,&tambah.nilai[0],&tambah.nilai[1],&tambah.nilai[2],&tambah.nilai[3],&tambah.nilai[4])!=EOF)
		{
			tambah.id++;	
		}
		cek.id = tambah.id;
		fclose(ptr1);
		printf ("masukan nama mahasiswa : ");fflush(stdin);
		scanf ("%[^\n]",tambah.nama);
		printf ("masukan JK mahasiswa : ");fflush(stdin);
		scanf ("%[^\n]",tambah.jk);
		printf ("masukan umur mahasiswa : ");fflush(stdin);
		scanf ("%d",&tambah.umur); 
		printf("Nilai UTS\t: ");
		scanf("%f",&tambah.nilai[0]);
		printf("Nilai Tugas\t: ");
		scanf("%f",&tambah.nilai[1]);
		printf("Nilai Kuis\t: ");
		scanf("%f",&tambah.nilai[2]);
		printf("Nilai UAS\t: ");
		scanf("%f",&tambah.nilai[3]);
		tambah.nilai[4]=(tambah.nilai[0]+tambah.nilai[1]+tambah.nilai[2]+tambah.nilai[3])/4;
		tambah.total = tambah.nilai[4];
		fprintf(ptr,"%d;%s;%s;%d;%f;%f;%f;%f;%f\n",tambah.id,tambah.nama,tambah.jk,tambah.umur,tambah.nilai[0],tambah.nilai[1],tambah.nilai[2],tambah.nilai[3],tambah.nilai[4]);
		fclose(ptr);
	
		printf("\n\nData Mahasiswa Sudah Disimpan !");
		add_invalid:
		printf("\n\n\tEnter 1 untuk menu utama dan 0 untuk keluar : ");
		switch(getch()){
    		case '1': menu();
        		break;
        	case '0': close();
        		break;
        	default:printf("\nMaaf Kesalahan Input !");
        		getche();
        		goto add_invalid;
 		}
}
void index_nilai(){
	if(tambah.nilai[4]>85 && tambah.nilai[4]<=100){
		strcpy(index, "A");
	}
	else if(tambah.nilai[4]>75 && tambah.nilai[4]<=85){
		strcpy(index, "B+");
	}
	else if(tambah.nilai[4]>65 && tambah.nilai[4]<=75){
		strcpy(index, "B");
	}
	else if(tambah.nilai[4]>55 && tambah.nilai[4]<=65){
		strcpy(index, "C+");
	}
	else if(tambah.nilai[4]>45 && tambah.nilai[4]<=55){
		strcpy(index, "C");
	}
	else if(tambah.nilai[4]>30 && tambah.nilai[4]<=45){
		strcpy(index, "D");
	}
	else if(tambah.nilai[4]>0 && tambah.nilai[4]<=30){
		strcpy(index, "E");
	}
}
void close(){
}
void tampil_mhs()
{
	FILE *view;
	view = fopen("mahasiswa.txt","r");
	int test=0;
	system ("cls");
	printf ("ID\t\tNAMA\t\tJK\t\tUMUR\t\tUTS\t\tTUGAS\t\tKUIS\t\tUAS\t\tRata-Rata\n");
	while (fscanf (view,"%d;%[^;];%[^;];%d;%f;%f;%f;%f;%f\n",&tambah.id,tambah.nama,tambah.jk,&tambah.umur,&tambah.nilai[0],&tambah.nilai[1],&tambah.nilai[2],&tambah.nilai[3],&tambah.nilai[4])!=EOF)
	{
		printf("%d\t\t%s\t%s\t\t%d\t\t%.2f\t\t%.2f\t\t%.2f\t\t%.2f\t\t%.2f\n",tambah.id,tambah.nama,tambah.jk,tambah.umur,tambah.nilai[0],tambah.nilai[1],tambah.nilai[2],tambah.nilai[3],tambah.nilai[4]);
		test++;
	}
	printf ("\nJumlah Data Mahasiswa : %d",test);
	fclose(view);
	
	if(test==0)
	{
		system("cls");
		printf ("\nData Kosong ! \n");
	}
	list_invalid:
    printf("\n\nEnter 1 untuk menu utama dan 0 untuk keluar : ");
    switch(getch()){
    	case '1': menu();
        	break;
        case '0': close();
        	break;
        default:printf("\nMaaf Kesalahan Input !");
        	getche();
        	goto list_invalid;
 	}
}
void cari_mhs()
{
	FILE *ptr;
	int test=0;
	system("cls");
	ptr=fopen("mahasiswa.txt","r");
	system("cls");
	printf("Input ID Mahasiswa : ");
	scanf("%d", &cek.id);
	while(fscanf (ptr,"%d;%[^;];%[^;];%d;%f;%f;%f;%f;%f\n",&tambah.id,tambah.nama,tambah.jk,&tambah.umur,&tambah.nilai[0],&tambah.nilai[1],&tambah.nilai[2],&tambah.nilai[3],&tambah.nilai[4])!=EOF){
		if(tambah.id==cek.id){
			test=1;
			index_nilai();
			printf ("\nID [%d]",tambah.id);
			printf("\nNama Mahasiswa\t: %s",tambah.nama);
			printf("\nJenis Kelamin\t: %s",tambah.jk);
			printf("\nUmur\t\t: %d",tambah.umur);
			printf("\nNilai UTS\t: %.2f",tambah.nilai[0]);
			printf("\nNilai Tugas\t: %.2f",tambah.nilai[1]);
			printf("\nNilai Kuis\t: %.2f",tambah.nilai[2]);
			printf("\nNilai UAS\t: %.2f",tambah.nilai[3]);
			printf("\nNilai Akhir\t: %.2f",tambah.nilai[4]);
			printf("\nPredikat\t: %s",index);
		}
	}
	fclose(ptr);
	if(test!=1){
		system("cls");
		detail_print:
		printf("\nData tidak ditemukan !\a\a\a");
		detail_invalid:
		printf("\nInput 0 untuk mencoba lagi, 1 untuk ke menu utama dan 2 untuk keluar :");
        switch(getch()){
            case '0': cari_mhs();
            	break;
            case '1': menu();
            	break;
            case '2': close();
            	break;
            default:printf("\nMaff Kesalahan Input !");
            	getche();
            	goto detail_invalid;
        }
	}else{
		detail_valid:
		printf("\n\n\nInput 1 untuk ke menu utama dan 0 untuk keluar :");
        switch(getch()){
        	case '1': menu();
       			break;
       		case '0': close();
       			break;
       		default:printf("\nMaaf Kesalahan Input !");
        		getche();
        		goto detail_valid;
       	}	
    }	
	
}
void header(){
	printf("HELLO WORLD !");
	time_t mytime;
	time(&mytime);
	printf("\n%s", ctime(&mytime));
	
}
void hapus_mhs()
{
	FILE *lama, *baru;
	int test=0;
	lama = fopen("mahasiswa.txt","r");
	baru = fopen("baru.txt","w");
	system("cls");
	printf("Input No. ID Mahasiswa yang akan di hapus : ");
	scanf("%d", &hapus.id);
	while(fscanf (lama,"%d;%[^;];%[^;];%d;%f;%f;%f;%f;%f\n",&tambah.id,tambah.nama,tambah.jk,&tambah.umur,&tambah.nilai[0],&tambah.nilai[1],&tambah.nilai[2],&tambah.nilai[3],&tambah.nilai[4])!=EOF)
	{
		if(tambah.id != hapus.id)
		{
			fprintf(baru,"%d;%s;%s;%d;%f;%f;%f;%f;%f\n",tambah.id,tambah.nama,tambah.jk,tambah.umur,tambah.nilai[0],tambah.nilai[1],tambah.nilai[2],tambah.nilai[3],tambah.nilai[4]);	
		}
		else{
			test++;
			printf("\nData Mahasiswa No ID : %d dengan Nama : %s\n",tambah.id,tambah.nama);
			printf("\nBerhasil dihapus dari Daftar !");
		}
	}
	fclose(lama);
	fclose(baru);
	remove("mahasiswa.txt");
	rename("baru.txt","mahasiswa.txt");
		if(test==0){
            printf("\nData tidak ditemukan !\a\a\a");
            erase_invalid:
            printf("\nInput 0 untuk mencoba lagi, 1 untuk ke menu utama and 2 untuk keluar :");
			switch(getch()){
            	case '0': hapus_mhs();
            		break;
            	case '1': menu();
            		break;
            	case '2': close();
            		break;
            	default:printf("\nMaaf Kesalahan Input !");
            		getche();
            		goto erase_invalid;
			}
    }
    else{
    	erase_valid:
		printf("\nInput 1 untuk ke menu utama and 0 untuk keluar :");
        switch(getch()){
       		case '1': menu();
       			break;
       		case '0': close();
       			break;
       		default:printf("\nMaaf Kesalahan Input !");
        		getche();
        		goto erase_valid;
        }
    }
	
}
void edit_mhs()
{
	int pilih,test=0;
	FILE *lama,*baru;
	lama = fopen("mahasiswa.txt","r");
	baru = fopen ("baru.txt","w");
	system("cls");
	
	printf ("Masukan ID Mahasiswa : ");
	scanf ("%d",&cek.id);
	while(fscanf (lama,"%d;%[^;];%[^;];%d;%f;%f;%f;%f;%f\n",&tambah.id,tambah.nama,tambah.jk,&tambah.umur,&tambah.nilai[0],&tambah.nilai[1],&tambah.nilai[2],&tambah.nilai[3],&tambah.nilai[4])!=EOF)
	{
		if(tambah.id == cek.id)
		{
			test=1;
			ganti:
				printf("\nNo. ID : %d dimiliki Mahasiswa dengan Nama : %s",tambah.id,tambah.nama);
				printf("\n\nData yang akan diganti : ");
				printf("\n[1]. Nama");
				printf("\n[2]. Jenis Kelamin");
				printf("\n[3]. Umur");
				printf("\nInput Pilihan : ");
				scanf("%d",&pilih);
				
				if(pilih == 1)
				{
					printf ("\nMasukan Data Nama Baru : ");fflush(stdin);
					scanf ("%[^\n]",cek.nama);
					strcpy(tambah.nama,cek.nama);
						fprintf(baru,"%d;%s;%s;%d;%f;%f;%f;%f;%f\n",tambah.id,tambah.nama,tambah.jk,tambah.umur,tambah.nilai[0],tambah.nilai[1],tambah.nilai[2],tambah.nilai[3],tambah.nilai[4]);
					printf ("\nPerubahan Sudah Disimpan !");
				}
				else if (pilih == 2)
				{
					printf("\nMasukan Data Jenis Kelamin L/P : ");fflush(stdin);
					scanf ("%[^\n]",cek.jk);
					strcpy(tambah.jk,cek.jk);
						fprintf(baru,"%d;%s;%s;%d;%f;%f;%f;%f;%f\n",tambah.id,tambah.nama,tambah.jk,tambah.umur,tambah.nilai[0],tambah.nilai[1],tambah.nilai[2],tambah.nilai[3],tambah.nilai[4]);
					printf ("\nPerubahan Sudah Disimpan !");
				}
				else if (pilih == 3)
				{
					printf ("\nMasukan Data Umur Baru : ");
					scanf ("%d",&cek.umur);
					tambah.umur = cek.umur;
					fprintf(baru,"%d;%s;%s;%d;%f;%f;%f;%f;%f\n",tambah.id,tambah.nama,tambah.jk,tambah.umur,tambah.nilai[0],tambah.nilai[1],tambah.nilai[2],tambah.nilai[3],tambah.nilai[4]);
					printf ("\nPerubahan Sudah Disimpan !");
				}
				else{
					printf("\n\nInput Anda Salah !");
					getche();
					goto ganti;
				}
		}
		else
		{
			fprintf(baru,"%d;%s;%s;%d;%f;%f;%f;%f;%f\n",tambah.id,tambah.nama,tambah.jk,tambah.umur,tambah.nilai[0],tambah.nilai[1],tambah.nilai[2],tambah.nilai[3],tambah.nilai[4]);
		}
	}

	fclose(lama);
	fclose(baru);
	remove("mahasiswa.txt");
	rename("baru.txt","mahasiswa.txt");
	if(test!=1){   
		system("cls");
        printf("\nData tidak ditemukan !\a\a\a");
        edit_invalid:
        printf("\nInput 0 untuk mencoba lagi, 1 untuk ke menu utama dan 2 untuk keluar :");
        switch(getch()){
            case '0': edit_mhs();
            	break;
            case '1': menu();
            	break;
            case '2': close();
            	break;
            default:printf("\nMaaf Kesalahan Input !");
            	getche();
            	goto edit_invalid;
        }
    }
    else{
    	edit_valid:
		printf("\n\n\nInput 1 untuk ke menu utama dan 0 untuk keluar :");
        switch(getch()){
        	case '1': menu();
        		break;
        	case '0': close();
        		break;
        	default:printf("\nMaaf Kesalahan Input !");
        		getche();
        		goto edit_valid;
        }
    }
}
void tampil_sort()
{
	system("cls");
	FILE *data;
	int count = 0,i,j,test=0,pil;
	system("cls");
	printf ("MENAMPILKAN TOTAL NILAI ASCENDING DAN DESCENDING\n");
	data=fopen("mahasiswa.txt","r");
	while(fscanf (data,"%d;%[^;];%[^;];%d;%f;%f;%f;%f;%f\n",&tambah.id,tambah.nama,tambah.jk,&tambah.umur,&tambah.nilai[0],&tambah.nilai[1],&tambah.nilai[2],&tambah.nilai[3],&tambah.nilai[4])!=EOF) {
		
		sort[count].total = tambah.nilai[4];
		sort[count].id = tambah.id;
		strcpy(sort[count].nama,tambah.nama);
		count++;
		test=1;
	}
	back:
	printf ("\n");
	printf ("1.ASCENDING\n");
	printf ("2.DESCENDING\n");
	printf("\nPilih: ");scanf("%d",&pil);
	
	if(pil==1)
	{
		printf ("ID\tNAMA\t\tTOTAL NILAI\n");
		for(i=0;i<count-1;i++){
			for(j=i+1;j<count;j++)
			{
				if(sort[i].total > sort[j].total)
				{
					temp = sort[j];
					sort[j] = sort[i];
					sort[i] = temp;
				}
			}
		}
		for(i=0;i<count;i++)
		{
			printf("%d\t%s\t%d\n",sort[i].id,sort[i].nama,sort[i].total);
		}
	}
	else if (pil == 2)
	{
		printf ("ID\tNAMA\t\tTOTAL NILAI\n");
		for(i=0;i<count-1;i++){
			for(j=i+1;j<count;j++)
			{
				if(sort[i].total < sort[j].total)
				{
					temp = sort[j];
					sort[j] = sort[i];
					sort[i] = temp;
				}
			}
		}
		for(i=0;i<count;i++)
		{
			printf("%d\t%s\t%d\n",sort[i].id,sort[i].nama,sort[i].total);
		}
	}
	else{
		printf ("Salah INPUT!\n");
		getch();
		goto back;
	}
	fclose(data);
	if(test==0){
            printf("\nData tidak ditemukan !\a\a\a");
            erase_invalid:
            printf("\nInput 0 untuk mencoba lagi, 1 untuk ke menu utama and 2 untuk keluar :");
			switch(getch()){
            	case '0': tampil_sort();
            		break;
            	case '1': menu();
            		break;
            	case '2': close();
            		break;
            	default:printf("\nMaaf Kesalahan Input !");
            		getche();
            		goto erase_invalid;
			}
    }
    else{
    	erase_valid:
		printf("\nInput 1 untuk ke menu utama and 0 untuk keluar :");
        switch(getch()){
       		case '1': menu();
       			break;
       		case '0': close();
       			break;
       		default:printf("\nMaaf Kesalahan Input !");
        		getche();
        		goto erase_valid;
        }
    }


	
}
void statistik_nilai(){
	system("cls");
	FILE *statistik;
	float max[5]={0,0,0,0,0},min[5]={100,100,100,100,100},sum[5]={0,0,0,0,0},avg[5];
	int count = 0,i;
	statistik=fopen("mahasiswa.txt","r");
	while(fscanf (statistik,"%d;%[^;];%[^;];%d;%f;%f;%f;%f;%f\n",&tambah.id,tambah.nama,tambah.jk,&tambah.umur,&tambah.nilai[0],&tambah.nilai[1],&tambah.nilai[2],&tambah.nilai[3],&tambah.nilai[4])!=EOF) {
		count++;
		/*perulangan nilai maximal*/
		for(i=0;i<=4;i++){
			if(max[i] < tambah.nilai[i]){
				max[i] = tambah.nilai[i];
			}
		}
		/*perulangan nilai minimal*/
		for(i=0;i<=4;i++){
			if(min[i] > tambah.nilai[i]){
				min[i] = tambah.nilai[i];
			}
		}
		/*perulangan penghitung jumlah nilai akhir*/
		for(i=0;i<=4;i++){
			sum[i] += tambah.nilai[i];
		}
		/*perulangan penghitung rata-rata*/
		for(i=0;i<=4;i++){
			avg[i]=sum[i]/count;
		}
	}
	printf("=============================================================");	
	printf("\nTerbesar\tUTS\tTugas\tKuis\tUAS\tNilai Akhir");
	printf("\nNilai\t\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f",max[0],max[1],max[2],max[3],max[4]);
	printf("\n=============================================================");	
	printf("\nTerkecil\tUTS\tTugas\tKuis\tUAS\tNilai Akhir");
	printf("\nNilai\t\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f",min[0],min[1],min[2],min[3],min[4]);
	printf("\n=============================================================");	
	printf("\nRata-rata\tUTS\tTugas\tKuis\tUAS\tNilai Akhir");
	printf("\nNilai\t\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f",avg[0],avg[1],avg[2],avg[3],avg[4]);
	printf("\n=============================================================");	
	
	fclose(statistik);
	
	printf("\n\nEnter 1 untuk menu utama dan 0 untuk keluar : ");
	list_invalid:
    switch(getch()){
    	case '1': menu();
        	break;
        case '0': close();
        	break;
        default:printf("\nMaaf Kesalahan Input !");
        	getche();
        	goto list_invalid;
 	}

}