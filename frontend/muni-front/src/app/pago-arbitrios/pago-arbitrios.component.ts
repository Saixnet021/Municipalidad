import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-pago-arbitrios',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './pago-arbitrios.component.html'
})
export class PagoArbitriosComponent implements OnInit {
  items: any[] = [];
  private apiUrl = 'http://localhost:8080/api/v1/arbitrios';

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.loadItems();
  }

  loadItems() {
    this.http.get<any[]>(`${this.apiUrl}/mis-deudas`).subscribe({
      next: (data) => this.items = data,
      error: (err) => console.error(err)
    });
  }

  pay(id: number) {
    if (confirm('¿Está seguro de realizar el pago?')) {
      this.http.post(`${this.apiUrl}/${id}/pagar`, {}).subscribe({
        next: () => {
          alert('Pago realizado con éxito');
          this.loadItems();
        },
        error: (err) => alert('Error al procesar el pago')
      });
    }
  }
}
