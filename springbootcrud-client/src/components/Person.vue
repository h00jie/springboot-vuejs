<template>
  <el-dialog :close-on-click-modal="false" :close-on-press-escape="false" :modal="true" :modal-append-to-body="false"
             :show-close="false"
             :visible="visible" @close="clearValidation" title="Διαχείριση Χρήστη" type="warning"
             width="75%">

    <el-card>
      <el-form :model="person" :rules="rules" label-position="top" ref="personForm">

        <el-row :gutter="20">
          <!-- LEFT COLUMN -->
          <el-col :span="12">

            <el-form-item label="Εισάγετε το όνομα"
                          prop="name">
              <el-input autoComplete="name"
                        placeholder="Όνομα"
                        prefix-icon="fa fa-user"
                        v-model="person.name">
              </el-input>
            </el-form-item>

            <el-form-item label="Εισάγετε αριθμό κινητού τηλεφώνου"
                          prop="mobilePhone">
              <el-input autoComplete="tel"
                        placeholder="Κινητό Τηλέφωνο"
                        prefix-icon="fa fa-phone"
                        v-model="person.mobilePhone">
              </el-input>
            </el-form-item>

            <el-form-item label="Εισάγετε τη διεύθυνση Email"
                          prop="email">
              <el-input autoComplete="email"
                        placeholder="Email"
                        prefix-icon="fa fa-envelope"
                        type="email"
                        v-model="person.email">
              </el-input>
            </el-form-item>

          </el-col>

          <!-- RIGHT COLUMN -->
          <el-col :span="12">

            <el-form-item label="Συμπληρώστε προαιρετικά σχόλια"
                          prop="comments">
              <el-input :rows="3"
                        placeholder="Σχόλια"
                        prefix-icon="fa fa-comment-o"
                        type="textarea"
                        v-model="person.comments">
              </el-input>
            </el-form-item>

            <el-form-item label="Επιλέξτε Φύλλο" prop="gender">
              <template>
                <el-select clearable
                           filterable
                           placeholder="Φύλλο"
                           v-model="person.gender"
                           value-key="id">
                  <el-option
                    :key="item.id"
                    :label="item.title"
                    :value="item"
                    v-for="item in genderOptions">
                  </el-option>
                </el-select>
              </template>
            </el-form-item>

            <el-form-item prop="active">
              <template>
                <el-checkbox v-model="person.active">Ενεργό</el-checkbox>
              </template>
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
<script src="./PersonVM.js"></script>
