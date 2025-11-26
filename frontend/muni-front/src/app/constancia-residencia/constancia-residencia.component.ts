import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-constancia-residencia',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './constancia-residencia.component.html'
})
export class ConstanciaResidenciaComponent implements OnInit {
  form: FormGroup;
  items: any[] = [];
  private apiUrl = 'http://localhost:8080/api/v1/constancia-residencia';

  constructor(private fb: FormBuilder, private http: HttpClient) {
    this.form = this.fb.group({
      direccion: ['', Validators.required],
      motivo: ['', Validators.required]
    });
  }

  ngOnInit() {
    this.loadItems();
  }

  loadItems() {
    this.http.get<any[]>(`${this.apiUrl}/mis-tramites`).subscribe({
      next: (data) => this.items = data,
      error: (err) => console.error(err)
    });
  }

  onSubmit() {
    if (this.form.valid) {
      this.http.post(this.apiUrl, this.form.value).subscribe({
        next: () => {
          this.form.reset();
          this.loadItems();
          alert('Solicitud enviada');
        },
        error: (err) => alert('Error al enviar solicitud')
      });
    }
  }
}
