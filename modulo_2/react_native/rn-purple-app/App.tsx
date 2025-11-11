import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';
import React from "react";
import "react-native-gesture-handler";
import RootNavigator from "./src/navigation/RootNavigator";
import 'react-native-reanimated';

export default function App() {
  return (
    <View style={styles.container}>
      <StatusBar style="light" />
      <RootNavigator />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});