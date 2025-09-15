import { HttpClientModule } from '@angular/common/http';
import { GraphQLModule } from './graphql.module';
import { NgModule } from '@angular/core';
import { ClientService } from './graphql/client.service';

@NgModule({
    imports: [
        HttpClientModule,
        GraphQLModule,
    ],
    providers: [ClientService],
})
export class AppModule { }
