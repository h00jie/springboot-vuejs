<template>
  <el-dialog :close-on-click-modal="false" :close-on-press-escape="false" :modal="true" :modal-append-to-body="false"
             :show-close="false"
             :visible="visible" @close="clearValidation" title="Διαχείριση Προμηθευτη" type="warning"
             width="75%">

    <el-card>
      <el-form :model="supplier" :rules="rules" label-position="top" ref="supplierForm">

        <el-row :gutter="20">
          <!-- LEFT COLUMN -->
          <el-col :span="12">

            <el-form-item label="Εισάγετε το όνομα εταιριας"
                          prop="firstName">
              <el-input autoComplete="companyName"
                        placeholder="όνομα εταιριας"
                        prefix-icon="fa fa-user"
                        v-model="supplier.companyName">
              </el-input>
            </el-form-item>

            <el-form-item label="Εισάγετε Ονομα"
                          prop="">
              <el-input autoComplete="firstName"
                        placeholder="first Name"
                        prefix-icon="fa fa-phone"
                        v-model="supplier.firstName">
              </el-input>
            </el-form-item>

            <el-form-item label="Εισάγετε last name"
                          prop="lastName">
              <el-input autoComplete="lastName"
                        placeholder="lastName"
                        prefix-icon="fa fa-envelope"
                        v-model="supplier.lastName">
              </el-input>
            </el-form-item>

            <el-form-item label="Εισάγετε ΑΦΜ"
                          prop="vatNumber">
              <el-input autoComplete="vatNumber"
                        placeholder="vatNumber"
                        prefix-icon="fa fa-envelope"
                        v-model="supplier.vatNumber">
              </el-input>
            </el-form-item>

            <el-form-item label="Εισάγετε EFORIA"
                          prop="irsOffice">
              <el-input autoComplete="irsOffice"
                        placeholder="irsOffice"
                        prefix-icon="fa fa-envelope"
                        v-model="supplier.irsOffice">
              </el-input>
            </el-form-item>
            <el-form-item label="Εισάγετε address"
                          prop="address">
              <el-input autoComplete="address"
                        placeholder="address"
                        prefix-icon="fa fa-envelope"
                        v-model="supplier.address">
              </el-input>
            </el-form-item>
            <el-form-item label="Εισάγετε T.K."
                          prop="zipCode">
              <el-input autoComplete="zipCode"
                        placeholder="zipCode"
                        prefix-icon="fa fa-envelope"
                        v-model="supplier.zipCode">
              </el-input>
            </el-form-item>
            <el-form-item label="Εισάγετε city"
                          prop="city">
              <el-input autoComplete="city"
                        placeholder="city"
                        prefix-icon="fa fa-envelope"
                        v-model="supplier.city">
              </el-input>
            </el-form-item>
            <el-form-item label="Εισάγετε country"
                          prop="country">
              <el-input autoComplete="country"
                        placeholder="country"
                        prefix-icon="fa fa-envelope"
                        v-model="supplier.country">
              </el-input>
            </el-form-item>
          </el-col>

        </el-row>

      </el-form>

      <el-row>
        <el-col style="text-align: right">
          <el-button @click="save"
                     icon="fa fa-save"
                     type="success"> Αποθήκευση
          </el-button>

          <el-button :disabled="!isDeletable"
                     @click="confirmDelete"
                     icon="fa fa-remove"
                     type="danger"> Διαγραφή
          </el-button>
        </el-col>
      </el-row>
    </el-card>

    <div class="dialog-footer card-footer" slot="footer">
      <el-button @click="cancel"
                 icon="el-icon-back"
                 type="warning"> Επιστροφή
      </el-button>
    </div>

  </el-dialog>
</template>
<script src="./SupplierVM.js"></script>
